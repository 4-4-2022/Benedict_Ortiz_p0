package com.ben.repository;

import java.util.ArrayList;
import java.util.HashSet;

import com.ben.model.Customer;

public interface CustomerRepository {
	
	
	public void create(Customer customer);
	public ArrayList<Customer> save();
	public void update(Customer customer);
	public void delete(Customer customer);
	
}
