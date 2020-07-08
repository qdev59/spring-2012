package com.acme.ex3a.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity @Table(name="T_EMPLOYEE")
@PrimaryKeyJoinColumn(name="ID_EMPLOYEE")
public class Employee extends AbstractHumanResource implements Serializable {

	private static final long serialVersionUID = 6386156087741451448L;

	@Column(name="LOGIN")
	private String login;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_CONTRACT")
	private Contract contract;

	@Column(name="START_DATE")
	private Date startDate;

	@Column(name="END_DATE")
	private Date endDate;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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

}
