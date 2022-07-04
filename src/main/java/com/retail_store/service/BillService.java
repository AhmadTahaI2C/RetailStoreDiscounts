package com.retail_store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail_store.model.Bill;
import com.retail_store.repository.BillRepository;

@Service
public class BillService {

	@Autowired
	private BillRepository billRepository;

	public Bill addBill(Bill bill) {
		return billRepository.save(bill);
	}

	public List<Bill> getBillByCustomerName(String customerName) {
		return billRepository.findByCustomerName(customerName);
	}
	
	

}
