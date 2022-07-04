package com.retail_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retail_store.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	public Employee findByEmpName(String empName);
	
	public Long  deleteByEmpName(String empName);

}
