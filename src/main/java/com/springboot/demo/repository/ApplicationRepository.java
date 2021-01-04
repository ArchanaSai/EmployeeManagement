package com.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.demo.model.Employee;
@Repository
public interface ApplicationRepository extends JpaRepository<Employee, Long> {

}
