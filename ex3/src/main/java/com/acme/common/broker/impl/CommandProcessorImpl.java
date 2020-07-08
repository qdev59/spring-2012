package com.acme.common.broker.impl;

import java.util.List;
import java.util.Map;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.acme.common.broker.AbstractCommand;
import com.acme.common.broker.CommandHandler;
import com.acme.common.broker.CommandPostProcessor;
import com.acme.common.broker.CommandPreProcessor;
import com.acme.common.broker.CommandProcessor;
import com.acme.common.business.exception.BusinessException;

public class CommandProcessorImpl implements CommandProcessor, MessageListener {

	@Override
	public void onMessage(Message arg0) {
		try {
			ObjectMessage obj = (ObjectMessage)arg0;
			Destination dest = obj.getJMSReplyTo();
			AbstractCommand cmd = (AbstractCommand) obj.getObject();
			cmd = this.process(cmd);
			// send cmd on dest
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private Map<Class<? extends AbstractCommand>, List<CommandHandler>> routing;
	private List<CommandProcessor> neighbours;

	private PlatformTransactionManager txManager;

	public CommandProcessorImpl(Map<Class<? extends AbstractCommand>, List<CommandHandler>> routing, PlatformTransactionManager txManager) {
		super();
		this.routing = routing;
		this.txManager = txManager;
		this.defRead = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
		this.defRead.setReadOnly(true);
		this.defWrite = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
	}

	private final DefaultTransactionDefinition defRead;
	private final DefaultTransactionDefinition defWrite;

	private List<CommandPreProcessor> preProcessors;
	private List<CommandPostProcessor> postProcessors;

	public void setPreProcessors(List<CommandPreProcessor> preProcessors) {
		this.preProcessors = preProcessors;
	}

	public void setPostProcessors(List<CommandPostProcessor> postProcessors) {
		this.postProcessors = postProcessors;
	}

	public void setNeighbours(List<CommandProcessor> neighbours) {
		this.neighbours = neighbours;
	}

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public AbstractCommand process(AbstractCommand command) throws BusinessException {
		String cmdId = command.toString();
		logger.info("I just receive a command : " + cmdId);
		logger.info("Is " + cmdId + " valid before process ?");
		long l = System.currentTimeMillis();
		command.validateStateBeforeProcess();
		
		// serialisation de cmd
		
		logger.info("yes, " + cmdId + " is valid, let's go");
		logger.info("open a transaction for " + cmdId + " (readOnly : " + command.readOnly + ")");
		TransactionStatus tx = this.txManager.getTransaction(command.readOnly ? this.defRead : this.defWrite);
		try {
			logger.info("any preProcessors for " + cmdId + " ? " + (this.preProcessors != null && !this.preProcessors.isEmpty()));
			if (this.preProcessors != null && !this.preProcessors.isEmpty()) {
				logger.info(this.preProcessors.size() + " preProcessors found for " + cmdId);
				for (CommandPreProcessor preProcessor : this.preProcessors) {
					logger.info("call " + preProcessor.getClass().getName() + "::preProcess on " + cmdId);
					preProcessor.preProcess(command);
				}
			}

			List<CommandHandler> handlers = this.routing.get(command.getClass());
			logger.info(handlers.size() + " handlers found for " + cmdId);
			for (CommandHandler commandHandler : handlers) {
				logger.info("call " + commandHandler.getClass().getName() + "::handle on " + cmdId);
				commandHandler.handle(command);
			}

			logger.info("any postProcessors for " + cmdId + " ? " + (this.postProcessors != null && !this.postProcessors.isEmpty()));
			if (this.postProcessors != null && !this.postProcessors.isEmpty()) {
				logger.info(this.postProcessors.size() + " postProcessors found for " + cmdId);
				for (CommandPostProcessor postProcessor : this.postProcessors) {
					logger.info("call " + postProcessor.getClass().getName() + "::postProcess on " + cmdId);
					postProcessor.postProcess(command);
				}
			}
			logger.info("Is " + cmdId + " valid after process ?");
			command.validateStateAfterProcess();
			logger.info("yes, " + cmdId + " is valid, commit transaction");
			this.txManager.commit(tx);
			logger.info("transaction committed for " + cmdId);
			long l2 = System.currentTimeMillis();
			if(l2-l>1000)
			{
				logger.warn("it took "+(l2-l)+" to process "+cmdId);
			}
			// serialisation de cmd
			if (this.neighbours != null && !this.neighbours.isEmpty()) {
				logger.info(this.neighbours.size() + " neighbours found for " + cmdId);
				if (/* !command.readOnly && */!command.isForwarded()) {
					command.setForwarded(true);
					for (CommandProcessor neighbour : this.neighbours) {
						try {
							logger.info("call " + neighbour.getClass().getName() + "::process on " + cmdId);
							neighbour.process(command);
						} catch (Exception e) {
							logger.warn("neighbour is not available : "+e.getMessage());
						}
					}
					command.setForwarded(false);
				} else {
					logger.info("command " + cmdId + " has been forwarded to me, don't forward it");
				}
			}
			
			return command;
		} catch (BusinessException exception) {
			logger.warn("an error occured (" + exception.getMessage() + ") for " + cmdId + ", rollback transaction");
			this.txManager.rollback(tx);
			throw exception;
		} catch (RuntimeException exception) {
			logger.error("an error occured (" + exception + ") for " + cmdId + ", rollback transaction");
			this.txManager.rollback(tx);
			// serialize command, and save command (as an xml file) and stack
			// trace
			throw new RuntimeException("Ooops !!");
		}
	}

}
