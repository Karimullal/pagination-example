package com.pagination.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pagination.app.model.Employee;
import com.pagination.app.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	public Page<Employee> getAllEmployee(int pageNo, int pageSize, String sort) {
		Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sort));
		return employeeRepo.findAll(pageable);
	}

	public Employee saveEmployee(Employee emp) {
		return employeeRepo.save(emp);
	}

	public void deleteEmployee(int id) {
		employeeRepo.deleteById(id);
	}

	public Employee updateEmployee(Employee emp) {
		Employee employee = new Employee();
		Optional<Employee> optional = employeeRepo.findById(emp.getId());
		if (optional.get() != null) {
			employee = optional.get();
			employee.setEmpName(emp.getEmpName());
			employee.setEmpNO(emp.getEmpNO());
			employee.setId(emp.getId());
			employee.setSalary(emp.getSalary());
			employee = employeeRepo.save(employee);
		}
		return employee;
	}
	
	public Employee getEmployeeById(int id) {
		return employeeRepo.findById(id).get();
	}

}
