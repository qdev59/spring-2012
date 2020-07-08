package com.acme.ex3a.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REF_CONTRACT")
public class Contract implements Serializable {

	private static final long serialVersionUID = -7427354870356321901L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CONTRACT")
	private Integer id;
	
	@Column(name="NAME")
	private String name;

	public Contract() {
		super();
	}

	public Contract(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
