package com.retail_store.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "RS_BILL")
public class Bill {
	
	
	@Id
	private Long billId;
	
	@Column(name="CUSTOMER_NAME")
	private String customerName;
	
	@Column(name="PAYABLE_AMOUNT")
	private String payableAmount;

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPayableAmount() {
		return payableAmount;
	}

	public void setPayableAmount(String payableAmount) {
		this.payableAmount = payableAmount;
	} 
	
	
	public BigDecimal getDecimalAmount() {
		return new BigDecimal(payableAmount).setScale(4, RoundingMode.HALF_UP);
	}
	
	
	

}
