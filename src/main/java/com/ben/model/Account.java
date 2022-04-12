package com.ben.model;

import java.util.ArrayList;

/*
 * accounts have users
 */
public class Account {

	private String accountName;
	private String accountPassword;
	//not sure if going to use this isAccountManager boolean
	private boolean isAccountManager;
	private ArrayList<User> userList = new ArrayList<User>();
	private int funds;

	/**
	 * @param accountName
	 * @param accountPassword
	 */
	public Account(String accountName, String accountPassword, boolean isAccountManager) {
		super();
		this.accountName = accountName;
		this.accountPassword = accountPassword;
		this.isAccountManager = isAccountManager;
		userList.add(new User("benUser", true));
		userList.add(new User("otherUser", false));
		funds = 100;
		
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountPassword() {
		return accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

	public boolean isAccountManager() {
		return isAccountManager;
	}

	public void setAccountManager(boolean isAccountManager) {
		this.isAccountManager = isAccountManager;
	}

	public ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}

	public int getFunds() {
		return funds;
	}

	public void setFunds(int funds) {
		this.funds = funds;
	}

	@Override
	public String toString() {
		return "Account [accountName=" + accountName + ", accountPassword=" + accountPassword + ", isAccountManager="
				+ isAccountManager + ", userList=" + userList + ", funds=" + funds + "]";
	}
	


}
