package com.ben.service;

import com.ben.model.Customer;
import com.ben.repository.CustomerRepository;

public class CustomerService {

	private CustomerRepository customerRepository;

	public void save(Customer customer) {
		this.customerRepository.save(customer);
	}

}
