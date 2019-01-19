package com.cg.ems.service;

import java.util.List;

import com.cg.ems.exception.EMSException;
import com.cg.ems.model.Employee;

public interface EmployeeService {

	boolean validateFields(String username, String password) throws EMSException;

	boolean getvaldate(String firstname) throws EMSException;

	boolean getvaldateaddress(String address) throws EMSException;

	boolean getvaldatenumber(String phonenumber);

	List<Employee> getgradelimit(String grade) throws EMSException;

	int insertemploy(Employee employee) throws EMSException;

	List<Employee> getAllEmployee() throws EMSException;

	List<Employee> getemployee(String empid) throws EMSException;

	int update(String newone, String empid) throws EMSException;

	boolean getvaldat(String fname);

	int update1(String newone, String empid) throws EMSException;

	int update2(String add, String empid) throws EMSException;

	boolean getvaladdress(String add);

	boolean getvalnumber(String phoneno);

	int update3(String phoneno, String empid) throws EMSException;

}
