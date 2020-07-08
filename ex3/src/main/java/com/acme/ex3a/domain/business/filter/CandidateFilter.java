package com.acme.ex3a.domain.business.filter;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CandidateFilter implements Serializable {

	private static final long serialVersionUID = -4412827935723659606L;

	@Size(min=2)
	@NotNull
	private String name;

	private Integer managerId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

}
