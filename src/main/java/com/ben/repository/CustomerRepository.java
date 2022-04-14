package com.ben.repository;

import com.ben.model.Customer;

public interface CustomerRepository {
	
	
	public void save(Customer customer);
	public void update(Customer customer);
	public void delete(Customer customer);
	
}
