package com.pagination.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp_tbl")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "EMP_NAME")
	private String empName;
	@Column(name = "EMP_NO")
	private String empNO;
	@Column(name = "SALARY")
	private Double salary;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpNO() {
		return empNO;
	}

	public void setEmpNO(String empNO) {
		this.empNO = empNO;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Employee(Integer id, String empName, String empNO, Double salary) {
		super();
		this.id = id;
		this.empName = empName;
		this.empNO = empNO;
		this.salary = salary;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", empNO=" + empNO + ", salary=" + salary + "]";
	}

}
