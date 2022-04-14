package com.ben.model;

import java.util.ArrayList;

/*
 * customer has accounts
 */
public class Customer {
	
	private int customerID;
	private String customerName;
	private String customerPassword;
	private ArrayList<Account> accountList = new ArrayList<Account>();
	
	
	
	/**
	 * 
	 */
	public Customer() {
		super();
	}
	
	
	/**
	 * @param customerID
	 * @param customerName
	 * @param customerPassword
	 */
	public Customer(int customerID, String customerName, String customerPassword) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
	}


	/**
	 * @param customerName
	 * @param customerPassword
	 */
	public Customer(String customerName, String customerPassword) {
//		super();
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.accountList.add(new Account("benAccount", "benAccountPw", true));
		this.accountList.add(new Account("otherAccount", "otherAccountPw", false));
		this.accountList.add(new Account("jerryAccount", "jerryAccountPw", true));
		this.accountList.add(new Account("arnoldAccount", "arnoldAccountPw", false));
	}
	
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
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
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", customerPassword="
				+ customerPassword + ", accountList=" + accountList + "]";
	}
	
	
	
	
}
