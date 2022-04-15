package com.ben.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;

import com.ben.model.Customer;
import com.ben.util.ConnectionFactory;
import com.ben.util.ResourceCloser;

public class CustomerRepositoryImpl implements CustomerRepository{

	@Override
	public void create(Customer customer) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		final String SQL = "insert into customers (customer_username, customer_password) values(?, ?)";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, customer.getCustomerName());
			stmt.setString(2, customer.getCustomerPassword());
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeStatement(stmt);
		}
		
		
	}
	
	@Override
	public ArrayList<Customer> save() {
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		
		final String SQL = "select * from customers";
		
		try {
			conn = ConnectionFactory.getConnection();
			
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);
			
			while(set.next()) {
				customers.add(new Customer(
						set.getInt(1),
						set.getString(2),
						set.getString(3)
						));
				
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ResourceCloser.closeConnection(conn);
			ResourceCloser.closeResultSet(set);
			ResourceCloser.closeStatement(stmt);
		}
		
		return customers;
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	

}
