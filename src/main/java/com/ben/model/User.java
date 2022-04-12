package com.ben.model;

public class User {
	
	private String userName;
	private boolean isMainUser = true;
	
	/**
	 * @param userName
	 * @param userPassword
	 * @param isMainUser
	 */
	public User(String userName, boolean isMainUser) {
		super();
		this.userName = userName;
		this.isMainUser = isMainUser;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public boolean isMainUser() {
		return isMainUser;
	}
	public void setMainUser(boolean isMainUser) {
		this.isMainUser = isMainUser;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", isMainUser=" + isMainUser + "]";
	}

	
	

}
