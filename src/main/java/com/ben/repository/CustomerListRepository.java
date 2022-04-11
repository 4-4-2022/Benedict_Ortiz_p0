package com.ben.repository;

import java.util.ArrayList;

import com.ben.model.Customer;

public class CustomerListRepository {
	
	private ArrayList<Customer> customerList = new ArrayList<Customer>();

	public ArrayList<Customer> getCustomerList() {
		customerList.add(new Customer("ben", "password"));
		customerList.add(new Customer("other", "password"));
		return customerList;
	}

	public void setCustomerList(ArrayList<Customer> userList) {
		customerList = userList;
	}
	
	

}
