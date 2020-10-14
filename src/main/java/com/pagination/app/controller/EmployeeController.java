package com.pagination.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pagination.app.model.Employee;
import com.pagination.app.service.EmployeeService;

@RestController
@RequestMapping("/emp")
@CrossOrigin(origins = "*")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	private ResponseEntity<Page<Employee>> getAllEmployee(@RequestParam(name = "page", defaultValue = "0") int pageNo,
			@RequestParam(name = "size", defaultValue = "2") int pageSize,
			@RequestParam(name = "sort", defaultValue = "salary") String sort) {
		Page<Employee> employees = employeeService.getAllEmployee(pageNo, pageSize, sort);

		return new ResponseEntity<Page<Employee>>(employees, HttpStatus.OK);
	}
	
	@PostMapping
	private ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {
		return new ResponseEntity<Employee>(employeeService.saveEmployee(emp), HttpStatus.OK);
	}
	@DeleteMapping
	private ResponseEntity<Void> deleteEmployee(@RequestParam("id") int id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping
	private ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp){		
		return new ResponseEntity<Employee>(employeeService.updateEmployee(emp),HttpStatus.OK);
	}
	@GetMapping("/{id}")
	private ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id),HttpStatus.OK);
	}
	
}
