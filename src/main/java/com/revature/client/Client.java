package com.revature.client;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.model.User;
import com.revature.repository.CoffeeRepository;
import com.revature.repository.CoffeeRepositoryImpl;

public class Client {
	
	public static void registerPage() {
		System.out.println("Welcome to the register page. Enter a username you want to use and password you want to use."
				+ "If you want to go back to the login page enter 1.");
	}

	public static void loginPage() {
		System.out.println("Welcome to the login page. Please make a selection." + "\n 1. Sign in" + "\n 2. Register"
				+ "\n 3. Return to main page");
	}

	public static void coffeeShopPage() {
		// where you show the selection of coffees you can buy
	}

	public static void welcomeMessage() {
		System.out.println("Welcome to Ben's Coffee shop! Where we have coffee that would keep even the dead awake."
				+ "\n 1. View the coffee menu" + "\n 2. View the history of Ben's Coffee shop."
				+ "\n 3. Go to the login page." + "\n 4. Exit the coffee shop.");
	}

	public static void historyOfCoffeeShop() {
		System.out.println(
				"The history of the Coffee shop began in Seattle, Washington. \nStarted before Starbucks, their coffee has the tastiest"
						+ " and most caffeine content allowed by FDA for human consumption. \nGuaranteed to keep you awake with just one sip.");
	}

	public static void initializeSigninPageUI() {
		System.out.println("where sign in would happen");
	}

	public static void initializeRegisterPageUI() {
		Scanner scanner = new Scanner(System.in);

		boolean isUserInRegisterPage = true;
		while (isUserInRegisterPage) {
			
			registerPage();
			
			String registerPageUserAnswer = scanner.nextLine();
			
			if(registerPageUserAnswer.equals("1")) {
				break;
			}
			
			String registerPageUserPW = scanner.nextLine();
			
			User.addToUserList(new User(registerPageUserAnswer, registerPageUserPW));
			
			System.out.println(registerPageUserAnswer);
			System.out.println(registerPageUserPW);
			
			ArrayList<User> temp = User.getUserList();
			System.out.println(temp.toString());
			
			
			

		}
	}

	public static void initializeLoginPageUI() {

		Scanner scanner = new Scanner(System.in);

		boolean isUserInLoginPage = true;
		while (isUserInLoginPage) {

			loginPage();

			int userAnswer = scanner.nextInt();

			switch (userAnswer) {
			case 1:
				initializeSigninPageUI();
				break;
			case 2:
				initializeRegisterPageUI();
				break;
			case 3:
				isUserInLoginPage = false;
				break;
			}

		}
	}

	public static void intializeCoffeeShopUI() {

		CoffeeRepository coffeeRepository = new CoffeeRepositoryImpl();

		Scanner scanner = new Scanner(System.in);

		boolean isUserHere = true;
		boolean isLoggedIn = false;

		while (isUserHere) {

			welcomeMessage();

			int userAnswer = scanner.nextInt();

			switch (userAnswer) {
			case 1:
				coffeeRepository.printCoffeeList();
				break;
			case 2:
				historyOfCoffeeShop();
				break;
			case 3:
				initializeLoginPageUI();
				break;
			case 4:
				System.out.println("bye customer");
				isUserHere = false;
				break;

			}
		}
		scanner.close();
	}

}
