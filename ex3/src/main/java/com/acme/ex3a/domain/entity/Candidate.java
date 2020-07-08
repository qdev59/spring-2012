package com.acme.ex3a.domain.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "T_CANDIDATE")
@PrimaryKeyJoinColumn(name = "ID_CANDIDATE")
public class Candidate extends AbstractHumanResource implements Serializable {

	private static final long serialVersionUID = 3270096085243641499L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MANAGER")
	private Employee manager;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_CANDIDATE_STATUS")
	private CandidateStatus status;

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public CandidateStatus getStatus() {
		return status;
	}

	public void setStatus(CandidateStatus status) {
		this.status = status;
	}

}
