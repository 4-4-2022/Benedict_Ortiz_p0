package com.revature;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.client.AppUI;
import com.revature.model.Coffee;
import com.revature.repository.CoffeeRepository;

public class Driver {

	public static void main(String[] args) {

		AppUI.welcomeMessage();
		CoffeeRepository coffeeRepository = new CoffeeRepository();
		ArrayList<Coffee> coffeeList = coffeeRepository.getCoffeeList();

		Scanner scanner = new Scanner(System.in);

		boolean isUserHere = true;
		while (isUserHere) {

			int userAnswer = scanner.nextInt();

			switch (userAnswer) {
			case 1:
//				System.out.println("this is where the menu would be");
				for(int i = 0; i < coffeeList.size(); i++) {
					System.out.println(coffeeList.get(i));
				}
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
