package com.cg.ems.service;

import java.util.List;
import java.util.regex.Pattern;

import com.cg.ems.dao.EmployeeDAO;
import com.cg.ems.dao.EmployeeDaoImpl;
import com.cg.ems.exception.EMSException;
import com.cg.ems.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	EmployeeDAO employeeDao = new EmployeeDaoImpl();

	@Override
	public boolean validateFields(String username, String password) throws EMSException {
		return employeeDao.validateFields(username, password);
	}

	@Override
	public boolean getvaldate(String firstname) throws EMSException {
		String val = "[a-zA-Z]+$";
		boolean input = Pattern.matches(val, firstname);
		return input;
	}

	@Override
	public boolean getvaldateaddress(String address) throws EMSException {
		String val = "[a-zA-Z0-9/-]+$";
		boolean input = Pattern.matches(val, address);
		return input;
	}

	@Override
	public boolean getvaldatenumber(String phonenumber) {
		String val = "[6|7|8|9]{1}[0-9]{9}";
		boolean input = Pattern.matches(val, phonenumber);
		return input;
	}

	@Override
	public List<Employee> getgradelimit(String grade) throws EMSException {
		// TODO Auto-generated method stub
		return employeeDao.getgradelimit(grade);
	}

	@Override
	public int insertemploy(Employee employee) throws EMSException {
		// TODO Auto-generated method stub
		return employeeDao.insertemploy(employee);
	}

	@Override
	public List<Employee> getAllEmployee() throws EMSException {
		// TODO Auto-generated method stub
		return employeeDao.getAllEmployee();
	}

	@Override
	public List<Employee> getemployee(String empid) throws EMSException {
		// TODO Auto-generated method stub
		return employeeDao.getEmployee(empid);
	}

	@Override
	public int update(String newone, String empid) throws EMSException {
		// TODO Auto-generated method stub
		return employeeDao.update(newone, empid);
	}

	@Override
	public boolean getvaldat(String fname) {
		String val = "[a-zA-Z]+$";
		boolean input = Pattern.matches(val, fname);
		return input;
	}

	@Override
	public int update1(String newone, String empid) throws EMSException {
		// TODO Auto-generated method stub
		return employeeDao.update1(newone, empid);
	}

	@Override
	public int update2(String add, String empid) throws EMSException {

		return employeeDao.update2(add, empid);
	}

	@Override
	public boolean getvaladdress(String add) {
		// TODO Auto-generated method stub
		String val = "[a-zA-Z0-9/-]+$";
		boolean input = Pattern.matches(val, add);
		return input;
	}

	@Override
	public boolean getvalnumber(String phoneno) {
		String val = "[6|7|8|9]{1}[0-9]{9}";
		boolean input = Pattern.matches(val, phoneno);
		return input;
	}

	@Override
	public int update3(String phoneno, String empid) throws EMSException {
		// TODO Auto-generated method stub
		return employeeDao.update3(phoneno, empid);
	}

}
