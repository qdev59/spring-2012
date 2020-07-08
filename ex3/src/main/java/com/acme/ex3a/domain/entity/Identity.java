package com.acme.ex3a.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable // et non pas @Entity
public class Identity implements Serializable{

	private static final long serialVersionUID = -4588136938030754108L;

	@Column(name="FIRSTNAME")
	private String firstname;
	
	@Column(name="LASTNAME")
	private String lastname;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_TITLE")
	private Title title;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_COUNTRY")
	private Country nationality;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Country getNationality() {
		return nationality;
	}

	public void setNationality(Country nationality) {
		this.nationality = nationality;
	}

}
