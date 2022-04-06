package com.revature.model;

public class Customer extends User{
	/*
	 * think of customers with multiple accounts as this: bank user with multiple accounts, like checking and saving.
	 * This of customer class as the parent class.
	 * With 1 child class: accounts. You can make multiple accounts,
	 * The secondary user would be another user that can access this customer class.
	 * 
	 *  Think of it like this.
	 *  
	 *  Netflix needs a "user" account. With that user account you can create multiple "profiles".
	 *  A secondary user can access the first user account with a different username and different password if the original user gives that
	 *  secondary user access.
	 *  
	 */

	private String customerName;
	private int customerAge;
	private String customerAddress;
	private int customerDOB;
	private int funds = 0; //start with 0 funds 

	public int getFunds() {
		return funds;
	}

	public void setFunds(int funds) {
		this.funds = funds;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public int getCustomerDOB() {
		return customerDOB;
	}

	public void setCustomerDOB(int customerDOB) {
		this.customerDOB = customerDOB;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}

}
