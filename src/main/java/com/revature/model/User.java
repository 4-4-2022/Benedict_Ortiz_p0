package com.revature.model;

import java.util.*;

/*
 * the parent class 
 * 
 * notes for myself:
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
public class User {
	
	private ArrayList<Account> accountList = new ArrayList<Account>();
	private String userName;
	private int userAge;
	private String userAddress;
	
	public ArrayList<Account> getAccountList() {
		return accountList;
	}
	public void setAccountList(ArrayList<Account> accountList) {
		this.accountList = accountList;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public int getUserDOB() {
		return userDOB;
	}
	public void setUserDOB(int userDOB) {
		this.userDOB = userDOB;
	}
	private int userDOB;
	

}
