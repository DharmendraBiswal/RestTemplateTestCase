package com.springboot.RestTemplateForTestCases.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.RestTemplateForTestCases.model.Employee;
import com.springboot.RestTemplateForTestCases.model.Employees;

@Repository
public class EmployeeDAO {

	public static Employees employeeList = new Employees();

	static {
		employeeList.getEmployeeList().add(new Employee(1, "Ram", "kumar", "ram@yash.com"));
		employeeList.getEmployeeList().add(new Employee(2, "Shyam", "Das", "shyam@yash.com"));
		employeeList.getEmployeeList().add(new Employee(3, "Goal", "Roy", "goral.roy@yash.com"));
		employeeList.getEmployeeList().add(new Employee(4, "Devid", "John", "devid@yash.com"));

	}

	public Employees getAllEmployee() {
		return employeeList;
	}

	public void addEmployee(Employee emp) {

		employeeList.getEmployeeList().add(emp);
	}

}
