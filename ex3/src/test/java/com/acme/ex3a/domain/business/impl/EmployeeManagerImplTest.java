package com.acme.ex3a.domain.business.impl;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.acme.ex3a.domain.business.EmployeeManager;
import com.acme.ex3a.domain.business.exception.DuplicateLoginException;
import com.acme.ex3a.domain.business.exception.InvalidDateRangeException;
import com.acme.ex3a.domain.business.filter.EmployeeFilter;
import com.acme.ex3a.domain.entity.Contract;
import com.acme.ex3a.domain.entity.Country;
import com.acme.ex3a.domain.entity.Employee;
import com.acme.ex3a.domain.entity.Identity;
import com.acme.ex3a.domain.entity.Title;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:com/acme/ex3a/appCtxConfig.xml",
		"classpath:com/acme/ex3a/appCtxMain.xml" })
@TransactionConfiguration(transactionManager="txManager")
public class EmployeeManagerImplTest extends AbstractTransactionalJUnit4SpringContextTests
{
	@Inject
	private EmployeeManager manager;

	
	@Test(expected=InvalidDateRangeException.class)
	public void testSaveWithInvalidDates() throws DuplicateLoginException, InvalidDateRangeException {
		
		System.out.println(manager.getClass().getName());
		Calendar calendar = Calendar.getInstance();
		
		Employee employee = new Employee();
		employee.setIdentity(new Identity());
		employee.getIdentity().setFirstname("John");
		employee.getIdentity().setLastname("Doe");
		calendar.set(2012, 1, 24);
		employee.setStartDate(calendar.getTime());
		calendar.set(2011, 1, 24);
		employee.setEndDate(calendar.getTime());
		this.manager.save(employee);
	}
	
	@Test(expected=DuplicateLoginException.class)
	public void testSaveWithDuplicateLogin() throws DuplicateLoginException, InvalidDateRangeException {
		Employee employee = new Employee();
		employee.setIdentity(new Identity());
		employee.getIdentity().setFirstname("André");
		employee.getIdentity().setLastname("Roulet");
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(2012, 1, 24);
		employee.setStartDate(calendar.getTime());
		this.manager.save(employee);
	}

	@Test
	public void testSaveOk() throws DuplicateLoginException, InvalidDateRangeException {
		Employee employee = new Employee();
		employee.setIdentity(new Identity());
		employee.getIdentity().setFirstname("John");
		employee.getIdentity().setLastname("Doe");
		employee.getIdentity().setNationality(new Country());
		employee.getIdentity().getNationality().setId(1);
		employee.getIdentity().setTitle(new Title());
		employee.getIdentity().getTitle().setId(1);
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(2012, 1, 24);
		employee.setStartDate(calendar.getTime());
		
		employee.setContract(new Contract());
		employee.getContract().setId(2);
		
		this.manager.save(employee);
	}
	
	@Test
	public void testFind() {
		EmployeeFilter filter = new EmployeeFilter();
		List<Employee> employees = this.manager.find(filter);
		System.out.println("after first call");
		employees = this.manager.find(filter);
		employees = this.manager.find(filter);
		employees = this.manager.find(filter);
		employees = this.manager.find(filter);
		employees = this.manager.find(filter);
		for (Employee employee : employees) {
			System.out.println(employee.getIdentity().getLastname() + " "+ employee.getIdentity().getFirstname());
			System.out.println("title : "+ employee.getIdentity().getTitle().getName());
			System.out.println("country : "+ employee.getIdentity().getNationality().getName());
			System.out.println("contract : " + employee.getContract().getName());
			System.out.println("*************next*************");
		}
	}
	

}
