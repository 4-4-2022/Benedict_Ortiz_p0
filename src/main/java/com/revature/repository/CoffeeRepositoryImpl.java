package com.revature.repository;

import java.util.ArrayList;

import com.revature.model.Coffee;

public class CoffeeRepositoryImpl implements CoffeeRepository{
	
	private ArrayList<Coffee> coffeeList = new ArrayList<Coffee>();

	public CoffeeRepositoryImpl() {
		super();
		coffeeList.add(new Coffee("Caramel Latte", 15, "Ben's Cafe"));
		coffeeList.add(new Coffee("Macchiato", 12, "Ben's Cafe"));
		coffeeList.add(new Coffee("Cappucino", 10, "Ben's Cafe"));
		coffeeList.add(new Coffee("Black", 7, "Ben's Cafe"));
	}

	public ArrayList<Coffee> getCoffeeList() {
		return coffeeList;
	}

}
