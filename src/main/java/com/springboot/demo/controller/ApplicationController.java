package com.springboot.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.dao.EmployeeDao;
import com.springboot.demo.model.Employee;

@RestController
public class ApplicationController {
	
	@Autowired
	EmployeeDao employeeDao;
	
	@GetMapping(path = "/findEmployee")
	public List<Employee> findEmployee() {
		return employeeDao.findEmployee();
	}
	
	@PostMapping(path = "/getEmployee/{employeeID}")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable(value = "employeeID") long employeeID) {
		Optional<Employee> employee = employeeDao.getEmployeeDetails(employeeID);
		if(employee == null) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok().body(employee);
		}
	}
	
	@PostMapping(path = "/addEmployee")
	public Employee addEmployee(@Validated @RequestBody Employee employee) {
		Employee tempEmployee = employeeDao.saveEmployee(employee);
		tempEmployee.setStatus("Failed to add Employee details");
		return tempEmployee;
	}
	
	@PostMapping(path = "/updateEmployee")
	public ResponseEntity<Employee> updateEmployee(@Validated @RequestBody Employee employee) {
		Optional<Employee> employeeExists = employeeDao.getEmployeeDetails(employee.getEmployeeID());
		if(employeeExists == null) {
			return ResponseEntity.notFound().build();
		}
		else {
			Employee tempEmployee = employeeDao.updateEmployee(employee);
			tempEmployee.setStatus("Employee Details updated successfully");
			return ResponseEntity.ok().body(tempEmployee);
		}
	}
	
	@PostMapping(path = "/deleteEmployee")
	public ResponseEntity<Employee> deleteEmployee(@Validated @RequestBody Employee employee) {
		Optional<Employee> employeeExists = employeeDao.getEmployeeDetails(employee.getEmployeeID());
		if(employeeExists == null) {
			return ResponseEntity.notFound().build();
		}
		else {
			Employee tempEmployee = employeeDao.updateEmployee(employee);
			tempEmployee.setStatus("Employee Details updated successfully");
			return ResponseEntity.ok().body(tempEmployee);
		}
	}
}
