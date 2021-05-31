package AppRunArea;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import CalculatorsAndOrderTakers.AssembleFood;
import CalculatorsAndOrderTakers.CashRegister;
import CalculatorsAndOrderTakers.InventoryRoom;
import CalculatorsAndOrderTakers.OrderSheet;
import employees.BusBoy;
import employees.Chef;
import employees.Dishwasher;
import employees.ParttimeBusBoy;
import employees.ParttimeChef;
import employees.ParttimeDishwasher;
import employees.ParttimeWaiter;
import employees.Payroll;
import employees.Waiter;
import menu1.ChocolateMilkshake;
import menu1.Food;
import menu1.Fries1;
import menu1.Hamburger1;
import menu1.OnionRings1;
import menu1.Salad1;
import menu1.Spaghetti1;
import menu1.VanillaMilkshake;

public class MainApp {

	public static void main(String[] args) {

		///Initilaizing variables and instantiating classes to use
		Scanner input = new Scanner(System.in);
		int mainChoice = -1;
		int subChoice = -1;

		Payroll payEmployees = new Payroll(new BusBoy("Super", "Man", 123456789), new ParttimeBusBoy("Bat", "Man", 123987456, 10), new ParttimeBusBoy("Sponge", "Bob", 123987654, 6), new Waiter("Wonder", "Woman", 432156798),new Waiter("Frosty", "The Snowman Jr.", 321876458), new Waiter("Edgar Allan", "Poe", 0), new ParttimeWaiter("Captain", "America", 654123789, 4.5),
				new ParttimeWaiter("Mickey", "Mouse", 987123645, 3), new ParttimeWaiter("Minie", "Mouse", 987456321, 8.5), new ParttimeWaiter("Winnie", "The Pooh", 192837465, 5), new Chef("Peter", "Pan", 132546798), new Chef("Tinker", "Bell", 657483921), new Chef("Snow", "White", 567894321), new Chef("Donald", "Duck", 745632891), new ParttimeChef("Jiminy", "Cricket", 234567192, 7.5), new ParttimeChef("Evil", "Queen", 645378291, 5), new Dishwasher("Flash", "McQueen", 721635847),
				new ParttimeDishwasher("Klark", "Kent", 786538163, 4), new ParttimeDishwasher("Iron", "Man", 645378123, 5), new ParttimeDishwasher("Spider", "Man", 265437891, 9));

		int userInput = -1;
		int toppingInput = 0;
		// setting up classes
		ArrayList<Integer> order = new ArrayList<Integer>();
		OrderSheet orderSheet = new OrderSheet(order);
		String[] inventoryFoods = { "Hamburger", "Salad", "Spaghetti", "Fries", "Onion Rings", "Vanilla Milkshake", "Chocolate Milkshake" };
				
		double [] menuPrices = {6.0, 5.0, 10.0, 5.0, 5.5, 4, 4};
		ArrayList<Double> prices = new ArrayList<Double>();
		double costTotal = 0;
		ArrayList<String> inventoryItemNames = new ArrayList<String>();
		ArrayList<Food> inventoryItems = new ArrayList<Food>();
		InventoryRoom inventoryRoom = new InventoryRoom(inventoryItems, inventoryItemNames);
		Food[] baseItems = {new Hamburger1(6.0, "No Toppings"),new Salad1(5.0, "No Toppings"), new Spaghetti1(10.0, "No Toppings"),
				new Fries1(5.0, "ketchup"), new OnionRings1(5.5), new VanillaMilkshake(4), new ChocolateMilkshake(4)};
		ArrayList<String> topping = new ArrayList<String>();
		CashRegister cashregister = new CashRegister(1000.0);
		double customerPay = 0;
		
		// Putting items in inventory & filling up all arraylists
		for (int i = 0; i < inventoryFoods.length; i++) {
			inventoryItemNames.add(inventoryFoods[i]);
			orderSheet.getOrder().add(0);
			prices.add(menuPrices[i]);
			topping.add("No Topping");
			inventoryRoom.getInventoryItems().add(baseItems[i]);
		}
		
		//resetting order to 0 because loop is restarting
//		for (int i = 0; i < order.size(); i++) {
//			order.set(i , 0);
//		}
		//The main loop that starts interactive process
		while (mainChoice != 0) {
			try {
				System.out.println("Welcome to the restauraunt please choose an option");
				System.out.println("1. Employee management");
				System.out.println("2. Order menu");
				System.out.println("0 to exit system");
				mainChoice = input.nextInt();
				switch (mainChoice) {
				case 1:							///Employee management branch of code
					System.out.println("You picked employee managment \n");
					System.out.println("please pick a subroutine");
					System.out.println("1. Access Payroll");
					System.out.println("2. Access employee info");
					System.out.println("0 to return to main menu");
					subChoice = input.nextInt();

					switch (subChoice) {
					case 1:
						try {
							payEmployees.getPayed();
						} catch (Exception e) {
							System.out.println("Sorry input was invalid you will be brought back to main menu");
							break;
						}
						break;
					case 2:
						System.out.println(payEmployees.toString());
						break;
					case 0:
						System.out.println("Returning to main menu");
						break;
					default:
						System.out.println("Sorry invalid input returning to main menu /n");
					}
					break;

				case 2:			///Customer order fulfilment branch of code
					System.out.println("You picked order menu \n");
					orderSheet.setOrder(orderLoop(orderSheet, inventoryItemNames));///CALLS METHOD TO START CUSTOMER ORDER
					for (int i = 0; i < menuPrices.length; i++) {
						if(orderSheet.getOrder().get(i) != 0) {
							costTotal += prices.get(i);
						}
					}///Topping add code
					if(order.get(0) > 0) {
						System.out.println("Would you like toppings with that hamburger? \n");
						System.out.println("1 for cheese ($2.00)");
						System.out.println("2 for bacon ($2.00)");
						System.out.println("3 for mushroom ($2.00)");
						System.out.println("0 for no toppings");
						try {
							toppingInput = input.nextInt();
						} catch (InputMismatchException a) {
							System.out.println("You entered a letter or symbol again system will exit");
							break;
						}if(toppingInput == 1) {
							topping.set(0, "cheese");
							costTotal += 2;
						}else if(toppingInput == 2) {
							topping.set(0, "bacon");
							costTotal += 2;
						}else if(toppingInput == 3) {
							topping.set(0, "mushroom");
							costTotal += 2;
						}
					}
					if(order.get(1) > 0) {
						System.out.println("Would you like toppings with that Salad? \n");
						System.out.println("1 bacon bits ($2.00)");
						System.out.println("2 croutons ($2.00)");
						System.out.println("3 dressings ($2.00)");
						System.out.println("0 for no toppings");
						try {
							toppingInput = input.nextInt();
						} catch (InputMismatchException a) {
							System.out.println("You entered a letter or symbol again system will exit");
							break;
						}if(toppingInput == 1) {
							topping.set(1, "bacon bits");
							costTotal += 2;
						}else if(toppingInput == 2) {
							topping.set(1, "croutons");
							costTotal += 2;
						}else if(toppingInput == 3) {
							topping.set(1, "dressing");
							costTotal += 2;
						}
					}
					if(order.get(2) > 0) {
						System.out.println("Would you like toppings with that Spaghetti? \n");
						System.out.println("1 for extra sauce ($2.00)");
						System.out.println("2 for smoked meat ($2.00)");
						System.out.println("3 for meatballs ($2.00)");
						System.out.println("0 for no toppings");
						try {
							toppingInput = input.nextInt();
						} catch (InputMismatchException a) {
							System.out.println("You entered a letter or symbol again system will exit");
							break;
						}if(toppingInput == 1) {
							topping.set(2, "extra sauce");
							costTotal += 2;
						}else if(toppingInput == 2) {
							topping.set(2, "smoked meat");
							costTotal += 2;
						}else if(toppingInput == 3) {
							topping.set(2, "meatballs");
							costTotal += 2;
						}
					}
					if(order.get(3) > 0) {
						System.out.println("Would you like toppings with those fries? \n");
						System.out.println("1 for spicy mayo ($2.00)");
						System.out.println("2 for truffle mayo ($2.00)");
						System.out.println("3 for gravy ($2.00)");
						System.out.println("0 for no toppings");
						try {
							toppingInput = input.nextInt();
						} catch (InputMismatchException a) {
							System.out.println("You entered a letter or symbol again system will exit");
							break;
						}if(toppingInput == 1) {
							topping.set(3, "spicy mayo");
							costTotal += 2;
						}else if(toppingInput == 2) {
							topping.set(3, "truffle mayo");
							costTotal += 2;
						}else if(toppingInput == 3) {
							topping.set(3, "gravy");
							costTotal += 2;
						}
					}
					if(order.get(4) > 0) {
						System.out.println("Would you like toppings with those onion rings? \n");
						System.out.println("1 for spicy mayo ($2.00)");
						System.out.println("2 for truffle mayo ($2.00)");
						System.out.println("3 for gravy ($2.00)");
						System.out.println("0 for no toppings");
						try {
							toppingInput = input.nextInt();
						} catch (InputMismatchException a) {
							System.out.println("You entered a letter or symbol again system will exit");
							break;
						}if(toppingInput == 1) {
							topping.set(4, "spicy mayo");
							costTotal += 2;
						}else if(toppingInput == 2) {
							topping.set(4, "truffle mayo");
							costTotal += 2;
						}else if(toppingInput == 3) {
							topping.set(4, "gravy");
							costTotal += 2;
						}
					}
					if(order.get(5) > 0) {
						System.out.println("Would you like to add something to that Vanilla Milkshake? \n");
						System.out.println("1 for crushed oreos ($2.00)");
						System.out.println("2 for chocolate sprinkles ($2.00)");
						System.out.println("3 for cinnamon spice ($2.00)");
						System.out.println("0 for no addon");
						try {
							toppingInput = input.nextInt();
						} catch (InputMismatchException a) {
							System.out.println("You entered a letter or symbol again system will exit");
							break;
						}if(toppingInput == 1) {
							topping.set(5, "crushed oreos");
							costTotal += 2;
						}else if(toppingInput == 2) {
							topping.set(5, "chocolate sprinkles");
							costTotal += 2;
						}else if(toppingInput == 3) {
							topping.set(5, "cinnamon spice");
							costTotal += 2;
						}
					}
					if(order.get(6) > 0) {
						System.out.println("Would you like to add something to that Chocolate Milkshake? \n");
						System.out.println("1 for crushed oreos ($2.00)");
						System.out.println("2 for chocolate sprinkles ($2.00)");
						System.out.println("3 for cinnamon spice ($2.00)");
						System.out.println("0 for no addon");
						try {
							toppingInput = input.nextInt();
						} catch (InputMismatchException a) {
							System.out.println("You entered a letter or symbol again system will exit");
							break;
						}if(toppingInput == 1) {
							topping.set(6, "crushed oreos");
							costTotal += 2;
						}else if(toppingInput == 2) {
							topping.set(6, "chocolate sprinkles");
							costTotal += 2;
						}else if(toppingInput == 3) {
							topping.set(6, "cinnamon spice");
							costTotal += 2;
						}
					}///Calculating cost and giving customer their items
					boolean noOrder = true;
					for (int i = 0; i < order.size(); i++) {
						if(order.get(i) > 0) {
							noOrder = false;
							break;
						}
					}
					
					if(!noOrder) {
						System.out.println("Total cost is $" + costTotal + "\n");
						System.out.println("Please pay for your order by typing amount to give :");
						customerPay = input.nextDouble();
						if(cashregister.returnChange(costTotal, customerPay) < 0){
							System.out.println("Sorry paying customers only \n");
							userInput = 0;
							break;
						}else {
							//updating our current cash
							System.out.println("We now have $" + (cashregister.getCurrentCash() + costTotal) + " in our cash resgiter \n");
							cashregister.depositCash(cashregister.returnChange(costTotal, customerPay));
							System.out.println("Here is your change $" + cashregister.returnChange(costTotal, customerPay) + "\n");
							//assembling food classes
						}
						
						for (int i = 0; i < orderSheet.getOrder().size(); i++) {
							if(orderSheet.getOrder().get(i) != 0) {
								AssembleFood<Food> food = new AssembleFood<Food>(inventoryRoom.getInventoryItems().get(i));
								food.setTopping(topping.get(i));
								
									System.out.println("Here is your fresh " + food + " " + food.getTopping() + "\n");
								
								
//								if(i < 2) {
//									System.out.println("Here is your fresh " + food + " with " + topping.get(i) + "\n");
//								}else {
//									System.out.println("Here is your fresh " + food + "\n");
//								}
								
							}
						}
						int tipChoice = -1;
						System.out.println("would you like to tip the staff?");
						System.out.println("1. yes");
						System.out.println("2. no");
						try {
							tipChoice = input.nextInt();
						}catch (InputMismatchException y) {
							System.out.println("You entered a letter or symbol");
							System.out.println("You can now press 0 to exit or any other number to return to main menu");
							input.nextLine();
							try {
								userInput = input.nextInt();
							} catch (InputMismatchException a) {
								System.out.println("You entered a letter or symbol again system will exit");
								break;
							}
						}
						if(tipChoice == 1) {
							System.out.println("Type tip amount: ");
							try {
								double tip = input.nextDouble();
								if(tip > 0) {
									System.out.println("Thank you :) \n");
									break;
								}else {
									System.out.println("Thats a negative number!! :(");
								}
								
							}catch (InputMismatchException y) {
								System.out.println("You entered a letter or symbol");
								System.out.println("You can now press 0 to exit or any other number to return to main menu");
								input.nextLine();
								try {
									userInput = input.nextInt();
								} catch (InputMismatchException a) {
									System.out.println("You entered a letter or symbol again system will exit");
									break;
								}
							}
						}
						break;
					}
					break;
				case 0:
					System.out.println("You have chosen to exit");
					break;
				default:
					System.out.println("Wrong input system restarting \n");
				}
			} catch (InputMismatchException y) {
				System.out.println("You entered a letter or symbol");
				System.out.println("You can now press 0 to exit or any other number to return to main menu");
				input.nextLine();
				try {
					userInput = input.nextInt();
				} catch (InputMismatchException a) {
					System.out.println("You entered a letter or symbol again system will exit");
					break;
				}
			}catch (IllegalArgumentException b) {
				System.out.println("You entered an incorrect number");
				System.out.println("You can now press 0 to exit or any other number to return to main menu");
				input.nextLine();
				try {
					userInput = input.nextInt();
				} catch (InputMismatchException a) {
					System.out.println("You entered an incorrect letter again system will exit");
					break;
				}
			}
			
		}
	}

	public static ArrayList<Integer> orderLoop(OrderSheet orderSheet, ArrayList<String> inventoryItemNames) {	///Method to separate customer order loop code
		Scanner input = new Scanner(System.in);
		int userInput = -1;
		
		
		while (userInput != 0) {
			// Try block throws an exception if invalid inputs are entered by user
			try {
				System.out.println("Please choose an item to order");
				System.out.println("1. Press 1 to order Main Items");
				System.out.println("2. Press 2 to order Side-Dishes");
				System.out.println("3. Press 3 to order Drinks");
				System.out.println("Press 0 to exit");
				try {
					userInput = input.nextInt();
				} catch (InputMismatchException a) {
					System.out.println("You entered a letter or symbol again system will exit");
					break;
				}
				if (userInput < 0 || userInput > 3) {

					System.out.println("You entered an invalid number");
					System.out.println("You can now press 0 to exit or any other number to continue ordering");
					try {
						userInput = input.nextInt();
					} catch (InputMismatchException a) {
						System.out.println("You entered a letter system will exit");
						break;
					}

				}

				/// Main Menu Items
				if (userInput == 1) {
					System.out.println("Please choose a food");
					System.out.println("1. Press 1 to order a Hamburger ($6.00)");
					System.out.println("2. Press 2 to order a Salad ($5.00)");
					System.out.println("3. Press 3 to order Spaghetti ($10.00)");
					System.out.println("4. Press 4 to go back to previous options");
					System.out.println("Press 0 to exit ordering");
					try {
						userInput = input.nextInt();
					} catch (InputMismatchException a) {
						System.out.println("You entered a letter or symbol again system will exit");
						break;
					}
					if (userInput == 0) {
						System.out.println("You chose to exit ordering returning to main menu \n");
						break;
					}
					if (userInput == 1) {
						System.out.println("Hamurger added, would you like anything else? \n");
						int x = orderSheet.getOrder().get(0);
						orderSheet.getOrder().set(0, x + 1);
						continue;
					} else if (userInput == 2) {
						System.out.println("Salad added, would you like anything else? \n");
						int x = orderSheet.getOrder().get(1);
						orderSheet.getOrder().set(1, x + 1);
						continue;
					} else if (userInput == 3) {
						System.out.println("Spaghetti added, would you like anything else? \n");
						int x = orderSheet.getOrder().get(2);
						orderSheet.getOrder().set(2, x + 1);
						continue;
					}else if (userInput == 4) {
						continue;
					} else {
						System.out.println("You entered an invalid number");
						System.out.println("You can now press 0 to exit or any other number to continue ordering");
						try {
							userInput = input.nextInt();
							if(userInput > 0 || userInput < 0) {
								continue;
							}
						} catch (InputMismatchException a) {
							System.out.println("You entered a letter system will exit");
							break;
						}
					}
					if (userInput == 0 || userInput == 4) {
						continue;
					}
					if (userInput < 0 || userInput > 4) {
						throw new IllegalArgumentException("Wrong key entered");
					}
				}

				/// Side-Dish Items
				if (userInput == 2) {
					System.out.println("Please choose a Side-Dish");
					System.out.println("1. Press 1 to order Fries ($5.00)");
					System.out.println("2. Press 2 to order Onion Rings ($5.50)");
					System.out.println("3. Press 3 to go back to previous options");
					System.out.println("Press 0 to exit ordering");
					try {
						userInput = input.nextInt();
					} catch (InputMismatchException a) {
						System.out.println("You entered a letter or symbol again system will exit");
						break;
					}
					if (userInput == 0) {
						System.out.println("You chose to exit ordering returning to main menu \n");
						break;
					}
					if (userInput == 1) {
						System.out.println("Fries added, would you like anything else? \n");
						int x = orderSheet.getOrder().get(3);
						orderSheet.getOrder().set(3, x + 1);
						continue;
					} else if (userInput == 2) {
						System.out.println("Onion Rings added, would you like anything else? \n");
						int x = orderSheet.getOrder().get(4);
						orderSheet.getOrder().set(4, x + 1);
						continue;
					}else if (userInput == 3) {
						continue;
					}else {
						System.out.println("You entered an invalid number");
						System.out.println("You can now press 0 to exit or any other number to continue ordering");
						try {
							userInput = input.nextInt();
							if(userInput > 0 || userInput < 0) {
								continue;
							}
						} catch (InputMismatchException a) {
							System.out.println("You entered a letter system will exit");
							break;
						}
					}
					if (userInput == 0 || userInput == 3) {
						continue;
					}
					if (userInput < 0 || userInput > 3) {
						System.out.println("You entered an invalid number");
						System.out.println("You can now press 0 to exit or any other number to continue ordering");
						try {
							userInput = input.nextInt();
						} catch (InputMismatchException a) {
							System.out.println("You entered a letter system will exit");
							break;
						}
					}
				}

				/// Drink Items
				if (userInput == 3) {
					System.out.println();
					System.out.println("Please choose a Drink");
					System.out.println("1. Press 1 to order a Vanilla Milkshake ($5.50)");
					System.out.println("2. Press 2 to order a Chocolate Milkshake ($5.50)");
					System.out.println("3. Press 3 to go back to previous options");
					System.out.println("Press 0 to exit ordering");
					userInput = input.nextInt();
					if (userInput == 0) {
						System.out.println("You chose to exit ordering returning to main menu \n");
						break;
					}
					if (userInput == 1) {
						System.out.println("Vanilla Milkshake added, would you like anything else? \n");
						int x = orderSheet.getOrder().get(5);
						orderSheet.getOrder().set(5, x + 1);
						continue;
					} else if (userInput == 2) {
						System.out.println("Chocolate Milkshake added, would you like anything else? \n");
						int x = orderSheet.getOrder().get(6);
						orderSheet.getOrder().set(6, x + 1);
						continue;
					}else if (userInput == 3) {
						continue;
					}else {
						System.out.println("You entered an invalid number");
						System.out.println("You can now press 0 to exit or any other number to continue ordering");
						try {
							userInput = input.nextInt();
							if(userInput > 0 || userInput < 0) {
								continue;
							}
						} catch (InputMismatchException a) {
							System.out.println("You entered a letter system will exit");
							break;
						}
					}
					if (userInput == 0 || userInput == 3) {
						continue;
					}
					if (userInput < 0 || userInput > 3) {
						System.out.println("You entered an invalid number");
						System.out.println("You can now press 0 to exit or any other number to continue ordering");
						try {
							userInput = input.nextInt();
						} catch (InputMismatchException a) {
							System.out.println("You entered a letter system will exit");
							break;
						}
					}
				}

			}
			// Catches exceptions caused by user input
			catch (InputMismatchException y) {
				System.out.println("You entered a letter or symbol");
				System.out.println("You can now press 0 to exit or any other number to continue ordering");
				input.nextLine();
				try {
					userInput = input.nextInt();
				} catch (InputMismatchException a) {
					System.out.println("You entered a letter or symbol again system will exit");
					break;
				}
			}

		}
		boolean noOrder = true;
		for (int i = 0; i < orderSheet.getOrder().get(i); i++) {
			if(orderSheet.getOrder().get(i) > 0) {
				noOrder = false;
				break;
			}
		}
		if(!noOrder) {
			System.out.println("You ordered:");
			for (int i = 0; i < 7; i++) {
				int item = orderSheet.getOrder().get(i);
				if (item != 0) {
					System.out.println(inventoryItemNames.get(i) + " " + item);
				}
			}
		}
		

		return orderSheet.getOrder();
	}
}
//COMMENTS
