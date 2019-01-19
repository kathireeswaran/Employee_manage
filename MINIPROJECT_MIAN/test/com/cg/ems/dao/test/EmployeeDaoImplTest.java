package com.cg.ems.dao.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.ems.dao.EmployeeDAO;
import com.cg.ems.dao.EmployeeDaoImpl;
import com.cg.ems.exception.EMSException;
import com.cg.ems.model.Employee;

public class EmployeeDaoImplTest {
	EmployeeDAO empDao = null;

	@Before
	public void setUp() throws Exception {
		empDao = new EmployeeDaoImpl();
	}

	@Test
	public void testInsertemploy() {

		String dob = "04-10-1996";
		String jd = "04-10-1999";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date_dob = LocalDate.parse(dob, formatter);
		LocalDate date_jd = LocalDate.parse(jd, formatter);

		Employee employee = new Employee();
		employee.setEmpId("100000");
		employee.setFirstName("kathir");
		employee.setLastName("krishnan");
		employee.setDob(date_dob);
		employee.setJoiningDate(date_jd);
		employee.setDeptId(10);
		employee.setGradeCode("M1");
		employee.setDesgn("MANAGER");
		employee.setBasic(12000.0);
		employee.setGender("MALE");
		employee.setMartialStatus("SINGLE");
		employee.setAddress("CHENNAI");
		employee.setPhonenumber("8939165072");
		try {
			int result = empDao.insertemploy(employee);
			assertEquals(1, result);

		} catch (EMSException e) {
			
			e.printStackTrace();
		}

	}

	@Test
	public void testUpdate() {
	
		try {
			int result1 = empDao.update("Kathir", "100000");
			assertEquals(1, result1);

		} catch (EMSException e) {
			
			e.printStackTrace();
		}

		
	}

	@After
	public void tearDown() throws Exception {
		empDao = null;
	}

}
