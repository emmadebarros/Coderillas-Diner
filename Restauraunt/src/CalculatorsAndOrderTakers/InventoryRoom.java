package CalculatorsAndOrderTakers;
import java.util.ArrayList;

import menu1.Food;

public class InventoryRoom {
	ArrayList<Food> inventoryItems = new ArrayList<Food>(); //Contains amount of items available to serve or prepare food
	
	ArrayList<String> inventoryItemNames = new ArrayList<String>();  //names of available items (items are classes)

	public InventoryRoom(ArrayList<Food> inventoryItems, ArrayList<String> inventoryItemNames) {
		this.inventoryItems = inventoryItems;
		this.inventoryItemNames = inventoryItemNames;
	}
	
	@Override
	public String toString() {
		return "items in inventory: " + inventoryItemNames + " , amount of each item " + inventoryItems;
		
	}

	public ArrayList<Food> getInventoryItems() {
		return inventoryItems;
	}

	public ArrayList<String> getInventoryItemNames() {
		return inventoryItemNames;
	}
	
	
//	Object[] food = {Drink, Fries, Hamburger, Meal, OnionRings, Salad, Spaghetti};
//	InventoryItemNames.Arrays.asList(food);
}
