package com.acme.broker.command;

import java.util.Date;

import javax.annotation.security.RolesAllowed;

import com.acme.common.broker.AbstractCommand;
import com.acme.ex3a.domain.entity.Contract;
import com.acme.ex3a.domain.entity.Employee;

@RolesAllowed("ROLE_ADMIN")
public class HireCandidateCommand extends AbstractCommand {

	private static final long serialVersionUID = -4055375623292034685L;

	public HireCandidateCommand() {
		super(false);
	}

	private int candidateId;
	private Contract contract;
	
	private Date startDate;
	
	private Date endDate;
	private Employee employee;

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
