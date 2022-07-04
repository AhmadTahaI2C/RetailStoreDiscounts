package com.retail_store.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retail_store.model.Employee;
import com.retail_store.service.ServiceLocator;

@RestController
@RequestMapping("employee-rest")
public class EmployeeController {

	@Autowired
	private ServiceLocator serviceLocator;

	@PostMapping("/add")
	public ResponseEntity<Employee> save(@RequestBody Employee employee) {
		try {
			return new ResponseEntity<>(serviceLocator.getEmployeeService().addEmployee(employee), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		try {
			List<Employee> employees = serviceLocator.getEmployeeService().getEmployees();
			if (CollectionUtils.isEmpty(employees)) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(employees, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{name}")
	public ResponseEntity<Employee> getEmployee(@PathVariable String name) {
		try {
			Optional<Employee> employee = serviceLocator.getEmployeeService().getEmployee(name);
			if (employee.isPresent()) {
				return new ResponseEntity<>(employee.get(), HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		try {
			return new ResponseEntity<>(serviceLocator.getEmployeeService().updateEmployee(employee), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id) {
		try {
			serviceLocator.getEmployeeService().deleteEmployee(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ServiceLocator getServiceLocator() {
		return serviceLocator;
	}

	public void setServiceLocator(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}

}
