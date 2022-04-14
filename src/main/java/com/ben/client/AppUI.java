package com.ben.client;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.ben.model.Customer;

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
	
	/**
	 * this method handles user selection if they enter anything else but a number
	 * @param userAnswer
	 * @param scanner
	 * @return an int of what the user picked
	 */
	public static int handleUserSelection(int userAnswer, Scanner scanner) {
		
		try {
			userAnswer = scanner.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("You entered something other than a number, enter a choice that's a number and type enter");
//			e.printStackTrace();
		}
		
		return userAnswer;
	}
	
	public static Customer getCustomerInformation(Scanner scanner) {
		Customer customer = new Customer();
		
		System.out.println("Enter the customer you want to insert into the db");
		System.out.println("Enter the customer id: ");
		customer.setCustomerID(scanner.nextInt());
		System.out.println("Enter the customer username: ");
		customer.setCustomerName(scanner.nextLine());
		System.out.println("Enter the customer password: ");
		customer.setCustomerPassword(scanner.nextLine());
		
		return customer;
		
		
	}

}
