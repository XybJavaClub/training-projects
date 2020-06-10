package com.client;

import java.util.Date;

import com.dataObjects.Address;
import com.dataObjects.Employee;
import com.dataServices.EmployeeDao;

public class ClientTest {

	public static void main(String[] args) {
		try {
			EmployeeDao employeeDao = new EmployeeDao();
			createEmployee(employeeDao);
			// getEmployeebyId(employeeDao);
			// updateEmployeeById(employeeDao);
			// deleteEmployeeById(employeeDao);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void deleteEmployeeById(EmployeeDao employeeDao) {
		employeeDao.deleteEmployeeById(9);
	}

	private static void updateEmployeeById(EmployeeDao employeeDao) {
		employeeDao.updateEmployeeById(9, 60000.00);
	}

	private static void getEmployeebyId(EmployeeDao employeeDao) {
		Employee employee = employeeDao.fetchEmployeebyId(9);
		System.out.println(employee);
	}

	private static void createEmployee(EmployeeDao employeeDao) {
		 employeeDao.addEmployee(getEmployeeWithAddress());
		// employeeDao.persistEmployee(getEmployee1());
		// employeeDao.addOrUpdateEmployee(getEmployee2());
		// employeeDao.addEmployee(getEmployeeWithAddress());
	}

	private static Employee getEmployee() {
		Employee employee = new Employee();
		employee.setEmployeeName("Anna Bingel");
		employee.setEmail("anna.cs2017@gmail.com");
		employee.setSalary(50000.00);
		employee.setDoj(new Date());
		return employee;
	}

	private static Employee getEmployeeWithAddress() {
		Employee employee = new Employee();
		employee.setEmployeeName("Thor Odinson");
		employee.setEmail("todinson@gmail.com");
		employee.setSalary(50000.00);
		employee.setDoj(new Date());

		/*
		 * Address address = new Address(); address.setCity("Chennai");
		 * address.setState("Tamil Nade"); address.setStreet("Anna salai"); //
		 * employee.setAddress(address);
		 */
		
		  
		  Address pAddress = new Address(); 
		  pAddress.setCity("Chennai");
		  pAddress.setState("Tamil Nadu"); 
		  pAddress.setStreet("Anna salai");
		  employee.setPermanentAddress(pAddress);
		  
		  Address rAddress = new Address(); 
		  rAddress.setCity("Madurai");
		  rAddress.setState("Tamil Nadu"); 
		  rAddress.setStreet("Anna salai");
		  employee.setResisdencyAddress(rAddress);
		 

		return employee;
	}

	private static Employee getEmployee1() {
		Employee employee = new Employee();
		employee.setEmployeeName("Frank Bingel");
		employee.setEmail("frank.cs2017@gmail.com");
		employee.setSalary(30000.00);
		employee.setDoj(new Date());
		return employee;
	}

	private static Employee getEmployee2() {
		Employee employee = new Employee();
		employee.setEmployeeName("Sean Bingel");
		employee.setEmail("sean.cs2017@gmail.com");
		employee.setSalary(60000.00);
		employee.setDoj(new Date());
		return employee;
	}
}
