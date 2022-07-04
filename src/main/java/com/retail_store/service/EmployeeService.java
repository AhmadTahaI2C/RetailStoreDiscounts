package com.retail_store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail_store.model.Employee;
import com.retail_store.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	public Optional<Employee> getEmployee(String name) {
		return Optional.ofNullable(employeeRepository.findByEmpName(name));
	}

	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public boolean deleteEmployee(Long id) {

		Optional<Employee> findById = employeeRepository.findById(id);
		if (findById.isPresent()) {
			employeeRepository.delete(findById.get());
			return true;
		} else {
			return false;
		}

	}
}
