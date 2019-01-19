package com.cg.ems.dao;

import java.util.List;

import com.cg.ems.exception.EMSException;
import com.cg.ems.model.Employee;

public interface EmployeeDAO {

	boolean validateFields(String username, String password) throws EMSException;

	List<Employee> getgradelimit(String grade) throws EMSException;

	int insertemploy(Employee employee) throws EMSException;

	List<Employee> getAllEmployee() throws EMSException;

	List<Employee> getEmployee(String empid) throws EMSException;

	int update(String newone, String empid) throws EMSException;

	int update1(String newone, String empid) throws EMSException;

	int update2(String add, String empid) throws EMSException;

	int update3(String phoneno, String empid) throws EMSException;

}
