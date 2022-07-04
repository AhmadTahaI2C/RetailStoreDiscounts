package com.retail_store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retail_store.model.Bill;

public interface BillRepository extends JpaRepository<Bill,  Long> {
	
	public List<Bill> findByCustomerName(String customerName);

}
