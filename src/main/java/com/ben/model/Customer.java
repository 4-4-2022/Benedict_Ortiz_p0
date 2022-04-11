package com.ben.model;

import java.util.ArrayList;

public class Customer {
	
	private String customerName;
	private String customerPassword;
	private ArrayList<Account> accountList = new ArrayList<Account>();
	
	/**
	 * @param customerName
	 * @param customerPassword
	 */
	public Customer(String customerName, String customerPassword) {
		super();
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		accountList.add(new Account("benAccount", "benAccountPw", true));
		accountList.add(new Account("otherAccount", "otherAccountPw", false));
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	public ArrayList<Account> getAccountList() {
		return accountList;
	}
	public void setAccountList(ArrayList<Account> accountList) {
		this.accountList = accountList;
	}
	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", customerPassword=" + customerPassword + ", accountList="
				+ accountList + "]";
	}
	
	
}
