package com.acme.ex3a.domain.business.filter;

import java.io.Serializable;

public class EmployeeFilter implements Serializable {

	private static final long serialVersionUID = 3546245446940924976L;
	private String name;
	private Integer contractId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getContractId() {
		return contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}

}
