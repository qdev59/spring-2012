package com.acme.ex3a.domain.business;

import java.util.List;
import java.util.Map;

import com.acme.ex3a.domain.business.exception.DuplicateLoginException;
import com.acme.ex3a.domain.business.exception.InvalidDateRangeException;
import com.acme.ex3a.domain.business.filter.EmployeeFilter;
import com.acme.ex3a.domain.entity.BusinessDomain;
import com.acme.ex3a.domain.entity.Employee;
import com.acme.ex3a.domain.entity.SkillLevel;
import com.acme.ex3a.domain.entity.TechnicalDomain;

public interface EmployeeManager {

	Employee getDetails(int id);
	
	// avant de sauvegarder : 
	// vérifier que la date de début est inférieure à la date de fin 
	// si celle-ci est renseignée.
	// vérifier aussi qu'un autre employé n'a pas déjà le même login
	Employee save(Employee employee) throws DuplicateLoginException, InvalidDateRangeException;
	
	List<Employee> find(EmployeeFilter filter);
	
	List<Employee> match(Map<TechnicalDomain, SkillLevel> technicalDomains, Map<BusinessDomain, SkillLevel> businessDomains);
}
