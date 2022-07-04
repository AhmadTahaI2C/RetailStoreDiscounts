package com.retail_store.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class NetPayable {

	private Bill bill;

	private String netPayableAmount;

	private List<String> netPayableDescriptions;

	public NetPayable(Bill bill) {
		this.bill = bill;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public String getNetPayableAmount() {
		return netPayableAmount;
	}

	public void setNetPayableAmount(String netPayableAmount) {
		this.netPayableAmount = netPayableAmount;
	}

	public List<String> getNetPayableDescriptions() {
		return netPayableDescriptions;
	}

	public void setNetPayableDescriptions(List<String> netPayableDescriptions) {
		this.netPayableDescriptions = netPayableDescriptions;
	}

	public void setDecimalAmount(Double amount) {
		BigDecimal setScale = BigDecimal.valueOf(amount).setScale(4, RoundingMode.HALF_UP);
		setNetPayableAmount(setScale.toString());
	}

}
