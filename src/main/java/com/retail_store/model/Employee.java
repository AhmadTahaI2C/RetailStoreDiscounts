package com.retail_store.model;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "RS_EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;

	@Column(name = "EMP_NAME")
	private String empName;

	@Column(name = "EMP_DEPARTMENT")
	private String empDepartment;

	@CreationTimestamp
	@Column(name = "EMP_CREATED_AT",nullable = false,updatable = false)
	private Date empCreatedAt;

	@UpdateTimestamp
	@Column(name = "EMP_UPDATED_AT")
	private Date empUpdateAt;

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDepartment() {
		return empDepartment;
	}

	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}

	public Date getEmpCreatedAt() {
		return empCreatedAt;
	}

	public void setEmpCreatedAt(Date empCreatedAt) {
		this.empCreatedAt = empCreatedAt;
	}

	public Date getEmpUpdateAt() {
		return empUpdateAt;
	}

	public void setEmpUpdateAt(Date empUpdateAt) {
		this.empUpdateAt = empUpdateAt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(empId, empName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return empId == other.empId && Objects.equals(empName, other.empName);
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empDepartment=" + empDepartment + "]";
	}

}
