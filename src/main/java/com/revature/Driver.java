package com.revature;

import java.util.Scanner;

import com.revature.client.AppUI;

public class Driver {

	public static void main(String[] args) {

		AppUI.welcomeMessage();

		Scanner scanner = new Scanner(System.in);

		boolean isUserHere = true;
		while (isUserHere) {

			int userAnswer = scanner.nextInt();

			switch (userAnswer) {
			case 1:
				System.out.println("this is where the menu would be");

				break;
			case 2:
				AppUI.historyOfCoffeeShop();
				break;
			case 3:
				System.out.println("bye customer");
				isUserHere = false;
			}
		}
		scanner.close();
	}

}
