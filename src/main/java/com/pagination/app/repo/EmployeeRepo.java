package com.pagination.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pagination.app.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
