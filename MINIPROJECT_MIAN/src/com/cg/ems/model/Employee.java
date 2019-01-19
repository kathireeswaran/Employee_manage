package com.cg.ems.model;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Employee implements Serializable {
	private String userName;
	private String password;
	private String userType;
	private Integer deptId;
	private String deptName;
	private String empId;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private LocalDate joiningDate;
	private String desgn;
	private Double basic;
	private String gender;
	private String martialStatus;
	private String address;
	private String phonenumber;
	private String gradeCode;
	private String description;
	private Double minSalary;
	private Double maxSalary;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String userName, String password, String userType, Integer deptId, String deptName, String empId,
			String firstName, String lastName, LocalDate dob, LocalDate joiningDate, String desgn, Double basic,
			String gender, String martialStatus, String address, String phonenumber, String gradeCode,
			String description, Double minSalary, Double maxSalary) {
		super();
		this.userName = userName;
		this.password = password;
		this.userType = userType;
		this.deptId = deptId;
		this.deptName = deptName;
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.joiningDate = joiningDate;
		this.desgn = desgn;
		this.basic = basic;
		this.gender = gender;
		this.martialStatus = martialStatus;
		this.address = address;
		this.phonenumber = phonenumber;
		this.gradeCode = gradeCode;
		this.description = description;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String id) {
		this.empId = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getDesgn() {
		return desgn;
	}

	public void setDesgn(String desgn) {
		this.desgn = desgn;
	}

	public Double getBasic() {
		return basic;
	}

	public void setBasic(Double basic) {
		this.basic = basic;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMartialStatus() {
		return martialStatus;
	}

	public void setMartialStatus(String martialStatus) {
		this.martialStatus = martialStatus;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getGradeCode() {
		return gradeCode;
	}

	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(Double minSalary) {
		this.minSalary = minSalary;
	}

	public Double getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(Double maxSalary) {
		this.maxSalary = maxSalary;
	}

	@Override
	public String toString() {
		return "Employee [userName=" + userName + ", password=" + password + ", userType=" + userType + ", deptId="
				+ deptId + ", deptName=" + deptName + ", empId=" + empId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", dob=" + dob + ", joiningDate=" + joiningDate + ", desgn=" + desgn + ", basic=" + basic
				+ ", gender=" + gender + ", martialStatus=" + martialStatus + ", address=" + address + ", phonenumber="
				+ phonenumber + ", gradeCode=" + gradeCode + ", description=" + description + ", minSalary=" + minSalary
				+ ", maxSalary=" + maxSalary + "]";
	}

}
