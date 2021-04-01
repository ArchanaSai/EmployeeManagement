package com.springboot.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "DMS_EMPLOYEE")

public class Employee {
	@Id
	@Column(name = "DMS_EMPLOYEE_ID",updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long employeeID;
	
	@Column(name = "EMPLOYEE_NAME",nullable = false,updatable = true)
	private String employeeName;
	
	@Column(name = "EMPLOYEE_CODE",nullable = false,updatable = false)
	private String employeeCode;
	
	@Column(name = "JOINING_DATE",nullable = false,updatable = true)
	@DateTimeFormat (pattern = "YYYY-MM-DD")
	private Date joiningDate;
	
	@Column(name = "CURRENT_DESIGNATION",nullable = false,updatable = true)
	private String currentDesignation;
	
	@Column(name = "ACTIVE",updatable = true)
	private char active;
	
	@Column(name = "CREATED_BY",updatable = false)
	private String createdBy;
	
	@Column(name = "CREATED_DATE",updatable = false)
	private Date createdDate;
	
	@Column(name = "UPDATED_BY",updatable = true)
	private String updatedBy;
	
	@Column(name = "UPDATED_DATE",updatable = true)
	private Date updatedDate;
	
	@Transient
	private String status;
	
	public long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(long employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getCurrentDesignation() {
		return currentDesignation;
	}

	public void setCurrentDesignation(String currentDesignation) {
		this.currentDesignation = currentDesignation;
	}

	public char getActive() {
		return active;
	}

	public void setActive(char active) {
		this.active = active;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
