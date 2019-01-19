package com.cg.ems.dao;

public interface QueryMapper {
	public static final String usercheck = "select username from User_master where username=? and password=?";
	public static final String checkbasic = "select min_salary,max_salary from grade_master where grade_code=?";
	public static final String insertuser = "insert into employee values(empidseq.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String viewuser = "select * from employee";
	public static final String getuser = "select * from employee where emp_id=?";
	public static final String updateuser = "update employee set emp_first_name=? where emp_id=?";
	public static final String updatelast = "update employee set emp_last_name=? where emp_id=?";
	public static final String updateADD = "update employee set emp_home_address=? where emp_id=?";
	public static final String updateNO = "update employee set emp_contact_num=? where emp_id=?";
}
