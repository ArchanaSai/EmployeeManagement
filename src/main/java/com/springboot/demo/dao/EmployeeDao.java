package com.springboot.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.model.Employee;
import com.springboot.demo.repository.ApplicationRepository;

@Service
public class EmployeeDao {
	@Autowired
	ApplicationRepository applicationRepository;
	
	public List<Employee> findEmployee(){
		return applicationRepository.findAll();
	}
	
	public Optional<Employee> getEmployeeDetails(long employeeID) {
		return applicationRepository.findById(employeeID);
	}
	
	public Employee saveEmployee(Employee employee) {
		return applicationRepository.save(employee);
	}
	
	public void deleteEmployee(Employee employee) {
		applicationRepository.delete(employee);
	}
}
