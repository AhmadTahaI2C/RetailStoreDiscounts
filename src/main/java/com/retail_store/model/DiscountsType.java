package com.retail_store.model;

public enum DiscountsType {
	EMPLOYEE(30," * 30% Discount on order for employees."),//
	REGULAR_CUSTOMER(10," * 10% Discount on order for regular customer."),//
	EVERY_100(5," * $5 Discount for every $100 on the bill."),
	NO_DISCOUNT(5," ** No discount available.");

	private double discounts;
	private String discountsDescription;

	private DiscountsType(double discounts,String discountsDescription ) {
		this.discounts = discounts;
		this.discountsDescription=discountsDescription;
	}

	public double getDiscounts() {
		return discounts;
	}

	public String getDiscountsDescription() {
		return discountsDescription;
	}

}
