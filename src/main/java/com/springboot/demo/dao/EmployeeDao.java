package com.springboot.demo.dao;

import java.util.Date;
import java.sql.Timestamp;
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
	String userName = "adminUser";
	Date date= new Date();
	long time = date.getTime();
	Timestamp timeStamp = new Timestamp(time);
	
	public List<Employee> findEmployee(){
		return applicationRepository.findAll();
	}
	
	public Optional<Employee> getEmployeeDetails(long employeeID) {
		return applicationRepository.findById(employeeID);
	}
	
	public Employee saveEmployee(Employee employee) {
		employee.setActive('Y');
		employee.setUpdatedBy(userName);
		employee.setUpdatedDate(timeStamp);
		return applicationRepository.save(employee);
	}
	
	public Employee deleteEmployee(Employee employee) {
		employee.setActive('D');
		employee.setUpdatedBy(userName);
		employee.setUpdatedDate(timeStamp);
		return applicationRepository.save(employee);
	}

	public Employee updateEmployee(Employee employee) {
		employee.setActive('Y');
		employee.setUpdatedBy(userName);
		employee.setUpdatedDate(timeStamp);
		return applicationRepository.save(employee);
	}
	
}
