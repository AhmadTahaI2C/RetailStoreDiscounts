package com.retail_store.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RetailNetPayableConfig {

	@Value("${numOfRegularCustomer}")
	private int numOfRegularCustomer;
	
	

	public int getNumOfRegularCustomer() {
		return numOfRegularCustomer;
	}

	public void setNumOfRegularCustomer(int numOfRegularCustomer) {
		this.numOfRegularCustomer = numOfRegularCustomer;
	}

}
