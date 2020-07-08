package com.acme.ex3a.domain.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import com.acme.ex3a.domain.business.EmployeeManager;
import com.acme.ex3a.domain.business.exception.DuplicateLoginException;
import com.acme.ex3a.domain.business.exception.InvalidDateRangeException;
import com.acme.ex3a.domain.business.filter.EmployeeFilter;
import com.acme.ex3a.domain.entity.BusinessDomain;
import com.acme.ex3a.domain.entity.Employee;
import com.acme.ex3a.domain.entity.SkillLevel;
import com.acme.ex3a.domain.entity.TechnicalDomain;

public class EmployeeManagerImpl implements EmployeeManager {

	@PersistenceContext(type=PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
	@Override
	public Employee getDetails(int id) {
		return this.em.find(Employee.class, id);
	}

	@Override
	public Employee save(Employee employee) throws DuplicateLoginException,
			InvalidDateRangeException {
		//1. vérifier que date début < date fin si date fin est renseignée. Levée d'une exception sinon
		if(employee.getEndDate()!=null && employee.getEndDate().before(employee.getStartDate()))
		{
			throw new InvalidDateRangeException();
		}
		//2. déterminer le login si celui ci est nul
		if(employee.getLogin()==null)
		{
			employee.setLogin((employee.getIdentity().getFirstname().substring(0, 1)+employee.getIdentity().getLastname()).toLowerCase());
		}
		String jpaQuery = "select count(e) from Employee e where e.login=:login";
		TypedQuery<Long> query = em.createQuery(jpaQuery, Long.class);
		query.setParameter("login", employee.getLogin());
		Long l = query.getSingleResult();
		//3. vérifier qu'un autre employé n'a pas déjà le même login, levée d'une exception si oui.
		if(l>0)
		{
			throw new DuplicateLoginException();
		}
		this.em.persist(employee);
		return employee;	
	}

	@Override
	public List<Employee> find(EmployeeFilter filter) {
		String name = filter.getName();
		Integer contractId = filter.getContractId();
		String jpaQuery = "select e from Employee e where ";
		jpaQuery+="(:name is null or e.identity.lastname like :name) ";
		jpaQuery+="and (:cid is null or e.contract.id = :cid) ";
		
		TypedQuery<Employee> query = this.em.createQuery(jpaQuery, Employee.class);
		query.setParameter("name", name).setParameter("cid", contractId);
		
		return query.getResultList();
	}

	@Override
	public List<Employee> match(
			Map<TechnicalDomain, SkillLevel> technicalDomains,
			Map<BusinessDomain, SkillLevel> businessDomains) {
		
		boolean matchTechnicakSkills = (technicalDomains != null && !technicalDomains
				.isEmpty());
		boolean matchBusinessSkills = (businessDomains != null && !businessDomains
				.isEmpty());

		List<Employee> allEmployees = this.em.createQuery("from Employee e",
				Employee.class).getResultList();

		ArrayList<Employee> results = new ArrayList<Employee>();
		for (Employee employee : allEmployees) {
			boolean a = false;
			boolean b = false;

			// ATTENTION : getBusinessSkills = proxy qui va charger en base, bien examiner le batch size
			if (!matchBusinessSkills
					|| employee.getBusinessSkills().keySet()
							.containsAll(businessDomains.keySet())) {
				a = true;
			}
			if (!matchTechnicakSkills
					|| employee.getTechnicalSkills().keySet()
							.containsAll(technicalDomains.keySet())) {
				b = true;
			}
			if (a && b) {
				results.add(employee);
			}
		}

		return results;
	}

}
