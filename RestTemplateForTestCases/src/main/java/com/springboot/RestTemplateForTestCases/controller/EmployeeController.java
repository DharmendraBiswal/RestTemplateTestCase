package com.springboot.RestTemplateForTestCases.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.RestTemplateForTestCases.dao.EmployeeDAO;
import com.springboot.RestTemplateForTestCases.model.Employee;
import com.springboot.RestTemplateForTestCases.model.Employees;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeDAO employeeDAO;

	@GetMapping(path = "/", produces = "application/json")
	public Employees getAll() {
		
		return employeeDAO.getAllEmployee();
	
	}

	@PostMapping(path = "/addEmployee", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {

		Integer id = employeeDAO.getAllEmployee().getEmployeeList().size()+1;
		employee.setId(id);

		employeeDAO.addEmployee(employee);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(employee.getId())
				.toUri();

		System.out.println(location);

		return ResponseEntity.created(location).build();

	}

}
