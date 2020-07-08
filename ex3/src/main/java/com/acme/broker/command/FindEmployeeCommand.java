package com.acme.broker.command;

import java.util.List;

import com.acme.common.broker.AbstractCommand;
import com.acme.ex3a.domain.business.filter.EmployeeFilter;
import com.acme.ex3a.domain.entity.Employee;

public class FindEmployeeCommand extends AbstractCommand {

	private static final long serialVersionUID = -7211206470077379528L;

	public FindEmployeeCommand() {
		super(true);
	}

	private Integer id;
	private EmployeeFilter filter;
	private Employee singleResult;
	private List<Employee> multipleResults;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EmployeeFilter getFilter() {
		return filter;
	}

	public void setFilter(EmployeeFilter filter) {
		this.filter = filter;
	}

	public Employee getSingleResult() {
		return singleResult;
	}

	public void setSingleResult(Employee singleResult) {
		this.singleResult = singleResult;
	}

	public List<Employee> getMultipleResults() {
		return multipleResults;
	}

	public void setMultipleResults(List<Employee> multipleResults) {
		this.multipleResults = multipleResults;
	}

}
