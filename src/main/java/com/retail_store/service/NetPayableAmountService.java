package com.retail_store.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.retail_store.config.RetailNetPayableConfig;
import com.retail_store.model.Bill;
import com.retail_store.model.DiscountsType;
import com.retail_store.model.Employee;
import com.retail_store.model.NetPayable;

@Service
public class NetPayableAmountService {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private BillService billService;

	@Autowired
	private RetailNetPayableConfig netPayableConfig;

	/**
	 * 1. If the user is an employee of the store, he gets a 30% discount on
	 * orders.</br>
	 * 2. If the user is a regular customer of the store, he gets a 10%
	 * discount.</br>
	 * 3. For every $100 on the bill, there would be a $ 5 discount </br>
	 * 
	 * @param bill
	 * @return {@link NetPayable}
	 */
	public NetPayable findNetPayable(Bill bill) {

		NetPayable netPayable = new NetPayable(bill);
		double billAmount = bill.getDecimalAmount().doubleValue();
		netPayable.setNetPayableDescriptions(new ArrayList<>());

		// 1. If the user is an employee of the store, he gets a 30% discount on orders
		if (discountEmployeeCustomer(bill.getCustomerName(), billAmount)) {
			billAmount = billAmount - calculateDiscount(billAmount, DiscountsType.EMPLOYEE);
			netPayable.getNetPayableDescriptions().add(DiscountsType.EMPLOYEE.getDiscountsDescription());
		}

		// 2. If the user is a regular customer of the store, he gets a 10% discount
		if (discountRegularCustomer(bill.getCustomerName(), billAmount)) {
			billAmount = billAmount - calculateDiscount(billAmount, DiscountsType.REGULAR_CUSTOMER);
			netPayable.getNetPayableDescriptions().add(DiscountsType.REGULAR_CUSTOMER.getDiscountsDescription());
		}

		// 3.For every $100 on the bill, there would be a $ 5 discount
		if (discountEvery100(billAmount)) {
			int intAmount = ((int) (billAmount / 100)) * 100;
			billAmount = billAmount - calculateDiscount(intAmount, DiscountsType.every_100);
			netPayable.getNetPayableDescriptions().add(DiscountsType.every_100.getDiscountsDescription());
		}

		netPayable.setDecimalAmount(billAmount);

		if (CollectionUtils.isEmpty(netPayable.getNetPayableDescriptions())) {
			// No Discount
			netPayable.getNetPayableDescriptions().add(DiscountsType.NO_DISCOUNT.getDiscountsDescription());
		}

		return netPayable;
	}

	/**
	 * @param customerName
	 * @param billAmount
	 * @return true employee customer
	 */
	private boolean discountEmployeeCustomer(String customerName, double billAmount) {
		Optional<Employee> employee = employeeService.getEmployee(customerName);
		if (employee.isPresent()) {
			return true;
		}

		return false;
	}

	/**
	 * @param customerName
	 * @param billAmount
	 * @return true discount regular customer
	 */
	private boolean discountRegularCustomer(String customerName, double billAmount) {
		int numOfRegularCustomer = netPayableConfig.getNumOfRegularCustomer();
		List<Bill> billByCustomerName = billService.getBillByCustomerName(customerName);

		if (!CollectionUtils.isEmpty(billByCustomerName)//
				&& billByCustomerName.size() >= numOfRegularCustomer) {
			return true;
		}
		return false;
	}

	/**
	 * @param billAmount
	 * @return true discount for every 100
	 */
	private boolean discountEvery100(double billAmount) {
		if (billAmount >= 100) {
			return true;
		}
		return false;
	}

	public static double calculateDiscount(Number billAmount, DiscountsType discountsType) {
		double discount = discountsType.getDiscounts() / 100;
		return discount * billAmount.doubleValue();
	}

}
