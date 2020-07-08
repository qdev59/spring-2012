package com.acme.ex3a.domain.entity;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "T_HUMAN_RESOURCE")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class AbstractHumanResource implements Serializable {

	private static final long serialVersionUID = 2835622117133770111L;

	@Id
	@Column(name = "ID_HUMAN_RESOURCE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Embedded
	private Identity identity;

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="LINK_RESOURCE_TECHNICAL_DOMAIN",
			joinColumns=@JoinColumn(name="ID_HUMAN_RESOURCE"),
			inverseJoinColumns=@JoinColumn(name="ID_SKILL_LEVEL")
			)
	@MapKeyJoinColumn(name="ID_TECHNICAL_DOMAIN")
	private Map<TechnicalDomain, SkillLevel> technicalSkills;

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="LINK_RESOURCE_BUSINESS_DOMAIN",
			joinColumns=@JoinColumn(name="ID_HUMAN_RESOURCE"),
			inverseJoinColumns=@JoinColumn(name="ID_SKILL_LEVEL")
			)
	@MapKeyJoinColumn(name="ID_BUSINESS_DOMAIN")
	private Map<BusinessDomain, SkillLevel> businessSkills;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	public Map<TechnicalDomain, SkillLevel> getTechnicalSkills() {
		return technicalSkills;
	}

	public void setTechnicalSkills(
			Map<TechnicalDomain, SkillLevel> technicalSkills) {
		this.technicalSkills = technicalSkills;
	}

	public Map<BusinessDomain, SkillLevel> getBusinessSkills() {
		return businessSkills;
	}

	public void setBusinessSkills(Map<BusinessDomain, SkillLevel> businessSkills) {
		this.businessSkills = businessSkills;
	}

}
