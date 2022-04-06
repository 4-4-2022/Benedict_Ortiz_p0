package com.revature.client;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.model.Coffee;
import com.revature.repository.CoffeeRepository;
import com.revature.repository.CoffeeRepositoryImpl;

public class Client {
	
	
	public static void loginPage() {
		System.out.println("Welcome to the login page. Please make a selection."
				+ "\n 1. Sign in" + "\n 2. Register");
	}
	
	public static void coffeeShopPage() {
		//where you show the selection of coffees you can buy
	}

	public static void welcomeMessage() {
		System.out.println("Welcome to Ben's Coffee shop! Where we have coffee that would keep even the dead awake."
				+ "\n 1. View the coffee menu" + "\n 2. View the history of Ben's Coffee shop."
				+ "\n 3. Exit the coffee shop.");
	}

	public static void historyOfCoffeeShop() {
		System.out.println(
				"The history of the Coffee shop began in Seattle, Washington. \nStarted before Starbucks, their coffee has the tastiest"
						+ " and most caffeine content allowed by FDA for human consumption. \nGuaranteed to keep you awake with just one sip.");
	}
	
	public static void initializeLoginPageUI() {
		loginPage();
	}
	
	public static void intializeCoffeeShopUI() {
		CoffeeRepository coffeeRepository = new CoffeeRepositoryImpl();

		Scanner scanner = new Scanner(System.in);

		boolean isUserHere = true;
		while (isUserHere) {

			int userAnswer = scanner.nextInt();

			switch (userAnswer) {
			case 1:
				coffeeRepository.printCoffeeList();
				break;
			case 2:
				historyOfCoffeeShop();
				break;
			case 3:
				System.out.println("bye customer");
				isUserHere = false;
			}
		}
		scanner.close();
	}
	
	

}
