package com.cg.ems.main;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.ems.exception.EMSException;
import com.cg.ems.model.Employee;
import com.cg.ems.service.EmployeeService;
import com.cg.ems.service.EmployeeServiceImpl;

public class UserInterface {
	static Logger logger = Logger.getLogger(UserInterface.class);

	@SuppressWarnings("unused")
	public static void main(String[] args) throws EMSException {
		PropertyConfigurator.configure("resource/log4j.properties");
logger.info("main started");
		Scanner scanner = new Scanner(System.in);
		boolean result = false;
		DateTimeFormatter formatter = null;
		LocalDate date = null;
		LocalDate joindate = null;
		boolean flag = false;
		boolean vflag = false;
		boolean searchflag = false;
		logger.info("before services creation");
		EmployeeService service = new EmployeeServiceImpl();
logger.info("services created");
		do {
			logger.debug("validation loop started");
			System.out.println("Enter Username");
			String username = scanner.nextLine();
			System.out.println("Enter Password");
			String password = scanner.nextLine();

			try {
				result = service.validateFields(username, password);

				if (result == true) {
					int choice = 0;

					do {
						logger.debug("main loop started");
						scanner = new Scanner(System.in);
						System.out.println("******EMPLOYEMENT MANAGEMENT ADMIN CONSOLE**********");
						System.out.println("1:Insert Employee Details :");
						System.out.println("2:Update Employee Details :");
						System.out.println("3:View Employee Details :");
						System.out.println();
						System.out.println("Enter Your Choices");
						try {
							choice = scanner.nextInt();
							if (choice >= 1 && choice <= 3) {
								searchflag = true;
								scanner.nextLine();

								switch (choice) {
								case 1:
									String firstname = null;
									do {
										logger.debug("firstname loop started");
										System.out.println("Enter Your First Name");
										firstname = scanner.nextLine();
										boolean valflag = service.getvaldate(firstname);
										if (valflag == true)
											vflag = valflag;
										else
											System.err.println("Name should be Alphabet");
									
									} while (!vflag);
									logger.debug("firstname loop end");
									String lastname;
									vflag = false;
									do {
										logger.debug("lastname loop end");
										System.out.println("Enter Your Last Name");
										lastname = scanner.nextLine();
										boolean valflag = service.getvaldate(lastname);
										if (valflag == true)
											vflag = valflag;
										else
											System.err.println("Name should be Alphabet");
									} while (!vflag);
									logger.debug("lastname loop end");
									String dob = null;
									do {

										System.out.println("date of birth (dd-MM-yyyy)");
										dob = scanner.nextLine();

										formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

										try {
											date = LocalDate.parse(dob, formatter);
											LocalDate end = LocalDate.now();
											Period period = date.until(end);
											int age = period.getYears();
											if (age >= 18 && age <= 58)
												flag = true;
											else
												System.err.println("age should be greater than 18 and less than 58");
										} catch (DateTimeParseException e) {
											flag = false;
											System.err.println(
													"date is not in the given format, give the date in dd-MM-yyyy format ");
										}
									} while (!flag);
									String joiningDate = null;
									do {

										System.out.println("date of joining (dd-MM-yyyy)");
										joiningDate = scanner.nextLine();

										formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

										try {
											joindate = LocalDate.parse(joiningDate, formatter);
											date = LocalDate.parse(dob, formatter);
											Period period = date.until(joindate);
											int yrs = period.getYears();
											if (yrs > 0) {
												flag = true;
											} else {
												System.err.println("joining date you entered is before then ur dob");
												flag = false;
											}

										} catch (DateTimeParseException e) {
											flag = false;
											System.err.println(
													"date is not in the given format, give the date in dd-MM-yyyy format ");
										}
									} while (!flag);
									int dchoice = 0;
									int deptId = 0;
									String design = null;

									do {
										searchflag = false;
										scanner = new Scanner(System.in);
										System.out.println("Select Your Department");
										System.out.println("1:CLERK");
										System.out.println("2:SALESMAN");
										System.out.println("3:MANAGER");
										System.out.println("4:ANALYST");
										System.out.println();
										System.out.println("Enter Your Department");
										try {
											dchoice = scanner.nextInt();
											if ((dchoice >= 1 && dchoice <= 4)) {
												searchflag = true;
												scanner.nextLine();
												switch (dchoice) {
												case 1:
													deptId = 10;
													design = "CLERK";
													break;
												case 2:
													deptId = 20;
													design = "SALESMAN";
													break;
												case 3:
													deptId = 30;
													design = "MANAGER";
													break;
												case 4:
													deptId = 40;
													design = "ANALYST";
													break;

												default:
													System.err.println("Invalid Selection");
													break;
												}

											}
										} catch (InputMismatchException e) {
											System.err.println("INPUT SHOULD BE NUMBER");
										}
									} while (!searchflag);

									String grade = null;
									int gchoice = 0;

									do {
										searchflag = false;
										scanner = new Scanner(System.in);
										System.out.println("Select Your Grade");
										System.out.println("1.M1");
										System.out.println("2.M2");
										System.out.println("3.M3");
										System.out.println("4.M4");
										System.out.println("5.M5");
										System.out.println("6.M6");
										System.out.println("7.M7");
										System.out.println();
										System.out.println("Enter Your Grade");
										try {
											gchoice = scanner.nextInt();
											if (gchoice >= 1 && gchoice <= 7) {
												searchflag = true;
												switch (gchoice) {
												case 1:
													grade = "M1";
													break;
												case 2:
													grade = "M2";
													break;
												case 3:
													grade = "M3";
													break;
												case 4:
													grade = "M4";
													break;
												case 5:
													grade = "M5";
													break;
												case 6:
													grade = "M6";
													break;
												case 7:
													grade = "M7";
													break;

												default:
													System.err.println("Invalid Selection");
													break;
												}

											}
										} catch (InputMismatchException e) {
											System.err.println("INPUT MUST BE INTEGER");
										}

									} while (!searchflag);

									int mchoice;
									String gender = null;

									do {
										searchflag = false;
										scanner = new Scanner(System.in);
										System.out.println("select the gender");
										System.out.println("1.male");
										System.out.println("2.female");
										System.out.println("Select Your Choice");
										try {
											mchoice = scanner.nextInt();
											if (mchoice > 0 && mchoice < 3) {
												searchflag = true;
												switch (mchoice) {
												case 1:
													gender = "Male";
													break;
												case 2:
													gender = "Female";
													break;
												default:
													System.err.println("Invalid Selection");
													break;
												}
											}
										} catch (InputMismatchException e) {
											System.err.println("INPUT SHOULD BE INTEGER");
										}

									} while (!searchflag);

									double basic = 0;
									vflag = false;
									do {
										System.out.println("Enter Basic Salary");
										basic = scanner.nextDouble();
										double min = 0;
										double max = 0;
										List<Employee> list = service.getgradelimit(grade);
										if (list.size() > 0) {

											for (Employee emp1 : list) {
												min = emp1.getMinSalary();
												max = emp1.getMaxSalary();
											}
										}
										if (basic >= min && basic <= max) {
											vflag = true;
										} else
											System.err.println("basic doesn't match with ur grade ");
									} while (!vflag);
									int martialchoice;
									String MartialStatus = null;

									do {
										searchflag = false;
										scanner = new Scanner(System.in);
										System.out.println("Select Your Martial Status");
										System.out.println("1.Single");
										System.out.println("2.Married");
										System.out.println("3.Divorced");
										System.out.println("4.Separated");
										System.out.println("5.Windowed");
										System.out.println();
										System.out.println("Select Your Choice");
										try {
											martialchoice = scanner.nextInt();
											if (martialchoice >= 1 && martialchoice <= 5) {
												searchflag = true;
												scanner.nextLine();
												switch (martialchoice) {
												case 1:
													MartialStatus = "Single";
													break;
												case 2:
													MartialStatus = "Married";
													break;
												case 3:
													MartialStatus = "Divorced";
													break;
												case 4:
													MartialStatus = "Separated";
													break;
												case 5:
													MartialStatus = "Widowed";
													break;

												default:
													System.err.println("Invalid Selection");
													break;
												}

											}
										} catch (InputMismatchException e) {
											System.err.println("INPUT SHOULD BE INTEGER");
										}

									} while (!searchflag);

									String address = null;
									vflag = false;
									do {
										System.out.println("Enter Your Home Address");
										address = scanner.nextLine();
										boolean valflag = service.getvaldateaddress(address);
										if (valflag == true)
											vflag = valflag;
										else
											System.err.println("address should be Alphanumeric");
									} while (!vflag);
									String phonenumber = null;
									vflag = false;
									do {
										System.out.println("Enter Your phone");
										phonenumber = scanner.nextLine();
										boolean valflag = service.getvaldatenumber(phonenumber);
										if (valflag == true)
											vflag = valflag;
										else
											System.err.println("mobile number should be 10 digits");

									} while (!vflag);
									Employee employee = new Employee();
									employee.setFirstName(firstname);
									employee.setLastName(lastname);
									employee.setDob(date);
									employee.setJoiningDate(joindate);
									employee.setDeptId(deptId);
									employee.setDesgn(design);
									employee.setGender(gender);
									employee.setGradeCode(grade);
									employee.setBasic(basic);
									employee.setMartialStatus(MartialStatus);
									employee.setAddress(address);
									employee.setPhonenumber(phonenumber);
									try {
										int insert = service.insertemploy(employee);
										System.out.println("insert" + insert);
									} catch (EMSException e) {
										System.err.println("insert service is not established" + e);
									}
									break;
								case 2:

									boolean doflag = false;
									do {
										System.out.println("Enter Your Employee ID");
										String empid = scanner.nextLine();
										boolean validateflag = false;
										List<Employee> list1 = service.getemployee(empid);
										if (list1.size() > 0) {
											doflag = true;
											validateflag = true;
											System.err.println("EMPID" + "		" + "FIRST NAME" + "		"
													+ "LAST NAME" + "		" + "DATE OF BIRTH" + "		" + "JOIN DATE"
													+ "		" + "DEPARTMENT ID" + "		" + "DESIGNATION" + "		"
													+ "SALARY" + "		" + "GENDER" + "		" + "MARTIAL STATUS"
													+ "		" + "ADDRESS" + "		" + "NUMBER");
											for (Employee emp : list1) {
												System.out.println(emp.getEmpId() + "          " + emp.getFirstName()
														+ "                  " + emp.getLastName()
														+ "                    " + emp.getDob() + "               "
														+ emp.getJoiningDate() + "                 " + emp.getDeptId()
														+ "                 " + emp.getDesgn() + "                  "
														+ emp.getBasic() + "           " + emp.getGender()
														+ "           " + emp.getMartialStatus() + "         "
														+ emp.getAddress() + "         " + emp.getPhonenumber());
											}
											System.out.println("");
											System.out.println("enter the number column to update");
											int columnchoice = scanner.nextInt();
											scanner.hasNextLine();
											for (int i = 0; i < columnchoice; i++) {
												int cchoice = 0;
												String column = null;
												String newone = null;
												do {
													System.out.println("Select column to update");
													System.out.println("1:firstname");
													System.out.println("2:lastname");
													System.out.println("3.ADDRESS");
													System.out.println("4.NUMBER");
													System.out.println();
													System.out.println("Enter your Choice");
													cchoice = scanner.nextInt();
													scanner.nextLine();
													switch (cchoice) {
													case 1:
														String fname = null;

														do {
															boolean valf = false;
															System.out.println("Enter Your First Name");
															fname = scanner.nextLine();
															column = "emp_first_name";
															valf = service.getvaldat(fname);
															if (valf == true) {
																newone = fname;
																vflag = valf;
																try {
																	int result1 = service.update(newone, empid);
																	System.out.println("updated");
																} catch (Exception e) {
																	throw new EMSException(" NO DATA UPDATED");
																}
															} else
																System.err.println("Name should be Alphabet");
														} while (!vflag);
														break;
													case 2:
														String lname;
														vflag = false;
														do {
															System.out.println("Enter Your Last Name");
															lname = scanner.nextLine();
															boolean valf = service.getvaldate(lname);
															if (valf == true) {
																vflag = valf;
																newone = lname;
																try {
																	int result1 = service.update1(newone, empid);
																	System.out.println("updated");
																} catch (Exception e) {
																	throw new EMSException(" NO DATA UPDATED");
																}

															} else
																System.err.println("Name should be Alphabet");
														} while (!vflag);
														break;
													case 3:
														String add;
														vflag = false;
														do {
															boolean valflag = false;
															System.out.println("Enter Your Home Address");
															add = scanner.nextLine();
															valflag = service.getvaladdress(add);
															if (valflag == true) {
																vflag = valflag;
																try {
																	int result1 = service.update2(add, empid);
																	System.out.println(result1 + "updated");
																} catch (Exception e) {
																	throw new EMSException(" NO DATA UPDATED");
																}
															} else
																System.err.println("address should be Alphanumeric");
														} while (!vflag);
														break;
													case 4:
														String phoneno = null;
														vflag = false;

														do {
															boolean valflag = false;
															System.out.println("Enter Your phone");
															phoneno = scanner.nextLine();
															valflag = service.getvalnumber(phoneno);
															if (valflag == true) {
																vflag = valflag;
																try {
																	int result1 = service.update3(phoneno, empid);
																	System.out.println(result1 + "updated");
																} catch (Exception e) {
																	throw new EMSException(" NO DATA UPDATED");
																}
															} else
																System.err.println("mobile number should be 10 digits");

														} while (!vflag);
														break;
													default:
														System.err.println("INVALID SELECTION");
														break;
													}
												} while (!(cchoice >= 1 && cchoice <= 4));
											}
										} else {
											System.err.println("NO DATA FOUND");
											System.out.println("ENTER AGAIN....");

										}
									} while (!doflag);

									break;
								case 3:
									List<Employee> list = service.getAllEmployee();
									if (list.size() > 0) {
										System.err.println("EMPID" + "		" + "FIRST NAME" + "		" + "LAST NAME"
												+ "		" + "DATE OF BIRTH" + "		" + "JOIN DATE" + "		"
												+ "DEPARTMENT ID" + "		" + "DESIGNATION" + "		" + "SALARY"
												+ "		" + "GENDER" + "		" + "MARTIAL STATUS" + "		"
												+ "ADDRESS" + "		" + "NUMBER");
										for (Employee emp : list) {
											System.out.println(emp.getEmpId() + "          " + emp.getFirstName()
													+ "                  " + emp.getLastName() + "                    "
													+ emp.getDob() + "               " + emp.getJoiningDate()
													+ "                 " + emp.getDeptId() + "                 "
													+ emp.getDesgn() + "                  " + emp.getBasic()
													+ "           " + emp.getGender() + "           "
													+ emp.getMartialStatus() + "         " + emp.getAddress()
													+ "         " + emp.getPhonenumber());
										}
									} else {
										System.err.println("NO DATA FOUND");

									}
									break;
								default:
									System.out.println("Invalid Selection Try Again");
									System.out.println();
									break;
								}

							} else {
								System.err.println("PLEASE ENTER VALID OPTION RANGE(1-3)");
								searchflag = false;
							}

						} catch (InputMismatchException e) {
							System.err.println("INPUT MUST BE INTEGER");
						}
					} while (!searchflag);

				} else {
					System.out.println("username/password mismatched");
					result = false;
				}
			} catch (EMSException e) {
				throw new EMSException("services doesnt established");
			}
		} while (!result);

		scanner.close();

	}
}
