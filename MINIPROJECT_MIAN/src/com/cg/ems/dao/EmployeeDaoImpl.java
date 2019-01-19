package com.cg.ems.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import com.cg.ems.exception.EMSException;
import com.cg.ems.model.Employee;
import com.cg.ems.utility.JdbcUtility;

public class EmployeeDaoImpl implements EmployeeDAO {
	PreparedStatement statement = null;
	Connection connection = null;
/***
 * method		:validateFields
 * argument		:It's take model argument as an argument
 * return type	:Boolean
 * Author		:Capgemini
 * Date			:18-Jan-2018
 */
	@Override
	public boolean validateFields(String username, String password) throws EMSException {
		List<Employee> list = new ArrayList<>();
		ResultSet resultSet = null;
		connection = JdbcUtility.getConnection();
		boolean flag = false;
		try {
			statement = connection.prepareStatement(QueryMapper.usercheck);
			statement.setString(1, username);
			statement.setString(2, password);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String user = resultSet.getString("username");
				Employee emp = new Employee();
				emp.setUserName(user);
				list.add(emp);
			}
			if (list.isEmpty()) {
				flag = false;
			} else {
				flag = true;
			}
		} catch (SQLException e) {
			throw new EMSException("no data found for sql fault");
		}
		return flag;
	}
	/***
	 * method		:getgradelimit
	 * argument		:It's take String as an argument
	 * return type	:Returns the salary details for given EmployeeID
	 * Author		:Capgemini
	 * Date			:18-Jan-2018
	 */
	@Override
	public List<Employee> getgradelimit(String grade) throws EMSException {
		List<Employee> list2 = new ArrayList<>();
		ResultSet resultSet = null;
		connection = JdbcUtility.getConnection();
		try {
			statement = connection.prepareStatement(QueryMapper.checkbasic);
			statement.setString(1, grade);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Double minsal = resultSet.getDouble(1);
				Double maxsal = resultSet.getDouble(2);
				Employee employ = new Employee();
				employ.setMinSalary(minsal);
				employ.setMaxSalary(maxsal);
				list2.add(employ);
			}
		} catch (SQLException e) {
			throw new EMSException("no data found for sql query");
		}
		return list2;
	}
	/***
	 * method		:insertemploy
	 * argument		:It's take model argument as an argument
	 * return type	:Returns the acknowledgement for  insertion
	 * Author		:Capgemini
	 * Date			:18-Jan-2018
	 */
	@Override
	public int insertemploy(Employee employee) throws EMSException {
		Date dob = Date.valueOf(employee.getDob());
		Date joindate = Date.valueOf(employee.getJoiningDate());
		connection = JdbcUtility.getConnection();
		int result = 0;
		try {
			statement = connection.prepareStatement(QueryMapper.insertuser);
			statement.setString(1, employee.getFirstName());
			statement.setString(2, employee.getLastName());
			statement.setDate(3, dob);
			statement.setDate(4, joindate);
			statement.setInt(5, employee.getDeptId());
			statement.setString(6, employee.getGradeCode());
			statement.setString(7, employee.getDesgn());
			statement.setDouble(8, employee.getBasic());
			statement.setString(9, employee.getGender());
			statement.setString(10, employee.getMartialStatus());
			statement.setString(11, employee.getAddress());
			statement.setString(12, employee.getPhonenumber());
			result = statement.executeUpdate();
		} catch (SQLException e) {
			throw new EMSException("statement not created");
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new EMSException("proble in closing the statement");
			}
			try {
				connection.close();
			} catch (Exception e2) {
				throw new EMSException("connection is not closed");
			}
		}

		return result;
	}
	/***
	 * method		:getAllEmployee
	 * argument		:It's take model argument as an argument
	 * return type	:List containing employee details
	 * Author		:Capgemini
	 * Date			:18-Jan-2018
	 */
	@Override
	public List<Employee> getAllEmployee() throws EMSException {
		List<Employee> list3 = new ArrayList<>();
		ResultSet resultSet = null;
		connection = JdbcUtility.getConnection();
		try {
			statement = connection.prepareStatement(QueryMapper.viewuser);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String id = resultSet.getString(1);
				String fname = resultSet.getString(2);
				String lname = resultSet.getString(3);
				Date dob = resultSet.getDate(4);
				Date joindate = resultSet.getDate(5);
				int dept = resultSet.getInt(6);
				String grade = resultSet.getString(7);
				String desgn = resultSet.getString(8);
				double salary = resultSet.getDouble(9);
				String gen = resultSet.getString(10);
				String mrg = resultSet.getString(11);
				String add = resultSet.getString(12);
				String num = resultSet.getString(13);
				LocalDate date = dob.toLocalDate();
				LocalDate jdate = joindate.toLocalDate();
				Employee employee = new Employee();
				employee.setEmpId(id);
				employee.setFirstName(fname);
				employee.setLastName(lname);
				employee.setDob(date);
				employee.setJoiningDate(jdate);
				employee.setDeptId(dept);
				employee.setGradeCode(grade);
				employee.setDesgn(desgn);
				employee.setBasic(salary);
				employee.setGender(gen);
				employee.setMartialStatus(mrg);
				employee.setAddress(add);
				employee.setPhonenumber(num);
				list3.add(employee);

			}
		} catch (SQLException e) {
			throw new EMSException("statement doesn't executed");

		} finally {
			try {
				statement.close();
			} catch (Exception e2) {
				throw new EMSException("statement is not closed");
			}
			try {
				connection.close();
			} catch (Exception e2) {
				throw new EMSException("connection is not closed");
			}

		}

		return list3;
	}
	/***
	 * method		:getEmployee
	 * argument		:It's take String as an argument
	 * return type	:List contain details of specified employee id
	 * Author		:Capgemini
	 * Date			:18-Jan-2018
	 */
	@Override
	public List<Employee> getEmployee(String empid) throws EMSException {
		List<Employee> list4 = new ArrayList<>();
		ResultSet resultSet = null;
		connection = JdbcUtility.getConnection();
		try {
			statement = connection.prepareStatement(QueryMapper.getuser);
			statement.setString(1, empid);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String id = resultSet.getString(1);
				String fname = resultSet.getString(2);
				String lname = resultSet.getString(3);
				Date dob = resultSet.getDate(4);
				Date joindate = resultSet.getDate(5);
				int dept = resultSet.getInt(6);
				String grade = resultSet.getString(7);
				String desgn = resultSet.getString(8);
				double salary = resultSet.getDouble(9);
				String gen = resultSet.getString(10);
				String mrg = resultSet.getString(11);
				String add = resultSet.getString(12);
				String num = resultSet.getString(13);
				LocalDate date = dob.toLocalDate();
				LocalDate jdate = joindate.toLocalDate();
				Employee employee = new Employee();
				employee.setEmpId(id);
				employee.setFirstName(fname);
				employee.setLastName(lname);
				employee.setDob(date);
				employee.setJoiningDate(jdate);
				employee.setDeptId(dept);
				employee.setGradeCode(grade);
				employee.setDesgn(desgn);
				employee.setBasic(salary);
				employee.setGender(gen);
				employee.setMartialStatus(mrg);
				employee.setAddress(add);
				employee.setPhonenumber(num);
				list4.add(employee);
			}
		} catch (SQLException e) {
			throw new EMSException("statement doesn't executed");
		} finally {
			try {
				statement.close();
			} catch (Exception e2) {
				throw new EMSException("statement is not closed");
			}
			try {
				connection.close();
			} catch (Exception e2) {
				throw new EMSException("connection is not closed");
			}

		}

		return list4;
	}
	/***
	 * method		:update
	 * argument		:It's take two string  as an argument
	 * return type	:Returns the acknowledgement for  updation
	 * Author		:Capgemini
	 * Date			:18-Jan-2018
	 */
	@Override
	public int update(String newone, String empid) throws EMSException {
		connection = JdbcUtility.getConnection();
		int result = 0;
		try {
			statement = connection.prepareStatement(QueryMapper.updateuser);
			statement.setString(1, newone);
			statement.setString(2, empid);
			result = statement.executeUpdate();
		} catch (SQLException e) {
		
			throw new EMSException("sql Query doesn't executed");
		} finally {
			try {
				statement.close();
			} catch (Exception e2) {
				throw new EMSException("statement is not closed");
			}
			try {
				connection.close();
			} catch (Exception e2) {
				throw new EMSException("connection is not closed");
			}

		}
		return result;
	}/***
	 * method		:validateFields
	 * argument		:It's take two string  as an argument
	 * return type	:Returns the acknowledgement for  updation
	 * Author		:Capgemini
	 * Date			:18-Jan-2018
	 */

	@Override
	public int update1(String newone, String empid) throws EMSException {
		connection = JdbcUtility.getConnection();
		int result = 0;
		try {
			statement = connection.prepareStatement(QueryMapper.updatelast);
			statement.setString(1, newone);
			statement.setString(2, empid);
			result = statement.executeUpdate();
		} catch (SQLException e) {
			throw new EMSException("sql Query doesn't executed");
		} finally {
			try {
				statement.close();
			} catch (Exception e2) {
				throw new EMSException("statement is not closed");
			}
			try {
				connection.close();
			} catch (Exception e2) {
				throw new EMSException("connection is not closed");
			}

		}
		return result;

	}
	/***
	 * method		:validateFields
	 * argument		:It's take two string  as an argument
	 * return type	:Returns the acknowledgement for  updation
	 * Author		:Capgemini
	 * Date			:18-Jan-2018
	 */
	@Override
	public int update2(String add, String empid) throws EMSException {
		connection = JdbcUtility.getConnection();
		int result = 0;
		try {
			statement = connection.prepareStatement(QueryMapper.updateADD);
			statement.setString(1, add);
			statement.setString(2, empid);
			result = statement.executeUpdate();
		} catch (SQLException e) {
			throw new EMSException("sql Query doesn't executed");
		} finally {
			try {
				statement.close();
			} catch (Exception e2) {
				throw new EMSException("statement is not closed");
			}
			try {
				connection.close();
			} catch (Exception e2) {
				throw new EMSException("connection is not closed");
			}

		}
		return result;

	}
	/***
	 * method		:validateFields
	 * argument		:It's take two string  as an argument
	 * return type	:Returns the acknowledgement for  updation
	 * Author		:Capgemini
	 * Date			:18-Jan-2018
	 */
	@Override
	public int update3(String phoneno, String empid) throws EMSException {
		connection = JdbcUtility.getConnection();
		int result = 0;
		try {
			statement = connection.prepareStatement(QueryMapper.updateNO);
			statement.setString(1, phoneno);
			statement.setString(2, empid);
			result = statement.executeUpdate();
		} catch (SQLException e) {
			throw new EMSException("sql Query doesn't executed");
		} finally {
			try {
				statement.close();
			} catch (Exception e2) {
				throw new EMSException("statement is not closed");
			}
			try {
				connection.close();
			} catch (Exception e2) {
				throw new EMSException("connection is not closed");
			}

		}
		return result;

	}

}
