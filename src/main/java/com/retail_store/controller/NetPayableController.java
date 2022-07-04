package com.retail_store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retail_store.model.Bill;
import com.retail_store.model.NetPayable;
import com.retail_store.service.ServiceLocator;

@RestController
@RequestMapping("retailStore/net-payable")
public class NetPayableController {

	@Autowired
	private ServiceLocator serviceLocator;

	@PostMapping
	public ResponseEntity<NetPayable> discount(@RequestBody Bill bill) {
		try {
			NetPayable findNetPayable = serviceLocator.getNetPayableAmountService().findNetPayable(bill);
			serviceLocator.getBillService().addBill(bill);
			return new ResponseEntity<>(findNetPayable, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
