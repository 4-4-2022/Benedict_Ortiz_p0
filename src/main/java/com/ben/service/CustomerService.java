package com.ben.service;

import java.util.ArrayList;
import java.util.HashSet;

import com.ben.model.Customer;
import com.ben.repository.CustomerRepository;
import com.ben.repository.CustomerRepositoryImpl;

public class CustomerService {

	private CustomerRepository customerRepository;
	
	/**
	 * @param customerRepository
	 */
	public CustomerService() {
		super();
		this.customerRepository = new CustomerRepositoryImpl();
	}

	public void create(Customer customer) {
		this.customerRepository.create(customer);
	}
	
	/*
	 * reason this wasn't working initially was because ther was no object instance that was being made to call the read method
	 * making a constructor created the impl method that then points to customerRepository. A private variable rn that can be seen as
	 * private CustomerRepository customerRepository = null;
	 * 
	 * the CustomerService constructor created a new object of customerRepositoryImpl that allowed the customerRepository to use CustomerRepositoryImpl's methods
	 * 
	 */
	public ArrayList<Customer> read() {
		return this.customerRepository.read();
	}

}
