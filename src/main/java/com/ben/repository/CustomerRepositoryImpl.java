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
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ArrayList<Customer> read() {
		// TODO Auto-generated method stub
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		Connection conn = null;
		/*
		 * statment is for sql queries
		 */
		Statement stmt = null;
		/*
		 * resultset is for sql query results
		 */
		ResultSet set = null;
		/*
		 * convetion for final strings is to make it all capital letters
		 */
		
		final String SQL = "select * from customers";
		
		try {
			conn = ConnectionFactory.getConnection();
			
//			stmt = conn.prepareStatement(SQL);
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);
			
			while(set.next()) {
				customers.add(new Customer(
						set.getInt(1),
						set.getString(2),
						set.getString(3)
						));
				
//				String customer_username = set.getString("customer_username");
//				System.out.println(customer_username);
				
//				System.out.println();
			}
//			System.out.println(customers);
			
			
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
