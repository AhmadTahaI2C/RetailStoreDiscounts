package com.retail_store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceLocator {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private BillService billService;

	@Autowired
	private NetPayableAmountService netPayableAmountService;

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public BillService getBillService() {
		return billService;
	}

	public void setBillService(BillService billService) {
		this.billService = billService;
	}

	public NetPayableAmountService getNetPayableAmountService() {
		return netPayableAmountService;
	}

	public void setNetPayableAmountService(NetPayableAmountService netPayableAmountService) {
		this.netPayableAmountService = netPayableAmountService;
	}

}
