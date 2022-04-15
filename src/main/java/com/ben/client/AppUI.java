package com.ben.client;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.ben.model.Customer;
import com.ben.service.CustomerService;

/*
 * print statements of choices users see
 * getcustomerinfo
 * getaccountinfo
 * getuserinfo
 * 
 * 
 */
public class AppUI {
	

	public static void mainCustomerPage() {
		System.out.println("welcome to the main customer page enter 1 to login, 2 to register, 3 to exit, 4 to print customerList, 5 for employee login");
	}
	
	public static void registerPage() {
		System.out.println("welcome to the register page, register your username and password. type 1 to exit");
	}
	
	public static void loginPage() {
		System.out.println("welcome to the login page, login with your username and password. type 1 to exit");
	}
	
	/**
	 * this method handles user selection if they enter anything else but a number
	 * @param userAnswer
	 * @param scanner
	 * @return an int of what the user picked
	 */
	public static int handleUserSelectionNumberOnly(int userAnswer, Scanner scanner) {
		
		try {
			userAnswer = scanner.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("You entered something other than a number, enter a choice that's a number and type enter");
		}
		
		return userAnswer;
	}
	
	
	public static Customer getCustomerInformation(Scanner scanner) {
		Customer customer = new Customer();
		
		boolean customerInRegisterPage = true;
		while (customerInRegisterPage) {
			System.out.println("Enter the customer username: ");
			String customerUsername = scanner.nextLine();
			if(customerUsername.equals("1")) {
				break;
			}
			customer.setCustomerName(scanner.nextLine());
			System.out.println("Enter the customer password: ");
			customer.setCustomerPassword(scanner.nextLine());
		}
//		System.out.println("Enter the customer username and passwword");
//		System.out.println("Enter the customer id: ");
//		customer.setCustomerID(scanner.nextInt());
//		scanner.nextLine();//had to eat new line after entering an int then a string

		
		return customer;
		
		
	}
	
	/**
	 * method that prints what's on the customer table from the arraylist populated by the db
	 * @param customerService needs to be passed a CustomerService object
	 */
	public static void printCustomerRepo(CustomerService customerService) {
		for(Customer customer: customerService.save()) {
			System.out.println(customer);
		}
	}

}
