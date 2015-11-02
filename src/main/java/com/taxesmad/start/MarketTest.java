package com.taxesmad.start;

import java.util.Iterator;
import java.util.Scanner;

import com.taxesmad.model.Cart;
import com.taxesmad.model.CashierItem;
import com.taxesmad.util.Catalog;

public class MarketTest {
	/**
	 * Utility enumeration for Test listing. Identify the different options
	 * available in the program
	 * 
	 * @author Stefano Ferrante
	 *
	 */
	private enum Test {
		test1("1","1 book at 12.49|1 music CD at 14.99|1 chocolate bar at 0.85"),
		test2("2","1 imported box of chocolates at 10.00|1 imported bottle of perfume at 47.50"),
		test3("3","1 imported bottle of perfume at 27.99|1 bottle of perfume at 18.99|1 packet of headache pills at 9.75|1 box of imported chocolates at 11.25"),
		free("4","Compose the cart as you want choosing the products from the Catalog");

		private String index;
		private String description;

		Test(String index, String description) {
			this.index = index;
			this.description = description;
		}

		public String getIndex() {
			return index;
		}

		public String getDescription() {
			return description;
		}
		/**
		 * Return the test to be performed
		 * @param index
		 * @return
		 */
		public static Test retrieveTest(String index) {
			for (Test test : Test.values()) {
				if (test.getIndex().equalsIgnoreCase(index))
					return test;
			}
			return null;
		}

	}

	/**
	 * Start the application to test evaluation.
	 * The application allows the user to choose the test he want to perform.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		while (!exit) {
			printStartMenu();
			chooseTest(sc);
			System.out.println("Do you want to do another test ? [Y/N]");
			boolean nextTest = true;
			while(nextTest) {
				String yesNo = sc.next();
				if("Y".equalsIgnoreCase(yesNo)){
					nextTest=false;
				}else if("N".equalsIgnoreCase(yesNo)){
					nextTest=false;
					exit=true;
				}else {
					System.out.println("Please insert Y or N if you want to add another item.");
				}
			}

		}

	}
	
	/**
	 * Pick the correct test to be performed based on input inserted by the user and print the receipt 
	 * of the test.
	 * 
	 * @param sc
	 */
	private static void chooseTest(Scanner sc) {
		boolean exit = false;
		while (!exit) {
			String index = sc.next();
			Test pickedTest = Test.retrieveTest(index);
			if (pickedTest != null) {
				Cashier cashier = new Cashier();
				switch (pickedTest) {
				case test1:
					System.out.println(cashier.checkout(fillCartforTest1Cart()));
					break;
				case test2:
					System.out.println(cashier.checkout(fillCartforTest2Cart()));
					break;
				case test3:
					System.out.println(cashier.checkout(fillCartforTest3Cart()));
					break;
				case free:
					System.out.println(cashier.checkout(fillFreeCart(sc)));
				default:
					break;
				}
				
				exit = true;
			} else {
				System.out.println("Please choose a valid test using the value specified between [_]");
			}
		}

	}

	/**
	 * Print in the shell the list of available test.
	 * 
	 */
	private static void printStartMenu() {
		System.out.println("Select the test you want to perform:");
		for (Test test : Test.values()) {
			System.out.println(">[" + test.getIndex() + "] - "	+ test.getDescription());
		}
	}
	
	/**
	 * Print all the items available in the Catalog
	 * 
	 */
	private static void printCatalog(){
		System.out.println("Select an item for the cart using the code inside [_] - (I=Imported - L=Local)");
		for(Catalog shelf : Catalog.values()){
			System.out.println("> ["+shelf.getCode()+"] - " + shelf.getLabel() + "(" + (shelf.isImported()?"I":"L") + ") - Price:"+shelf.getPrice());
		}
	}
	
	/**
	 * Let the user decide if more items must be added to the cart or not.
	 * 
	 * @param sc
	 * @return true if the user decide to add more items false otherwise
	 */
	private static boolean addMoreItems(Scanner sc) {
		System.out.println("Do you want to insert another item ?[Y/N]");
		boolean nextItem = false;
		while(!nextItem) {
			String yesNo = sc.next();
			if("Y".equalsIgnoreCase(yesNo)){
				return true;
			}else if("N".equalsIgnoreCase(yesNo)){
				return false;
			}else {
				System.out.println("Please insert Y or N if you want to add another item.");
			}
		}
		return false;
	}
	
	/**
	 * The test allow the user to customize the test adding as much items he wants.
	 * 
	 * @param sc
	 * @return a cart build freely by the user
	 */
	private static Cart fillFreeCart(Scanner sc) {
			Cart cart = new Cart();
			boolean filled=false;
			while(!filled){
				printCatalog();
				String code = sc.next();
				CashierItem item = Catalog.retrieveFromCatalog(code);
				if(item == null){
					System.out.println("Please insert a valid code from the list");
					continue;
				}
				cart.add(item);
				System.out.println("Cart contains ["+cart.itemsContained()+"] items");
				if(!addMoreItems(sc))
					filled=true;
			}
			return cart;
	}
	
	/**
	 * Pre-configured test for specific list of items
	 * 
	 * @return the Cart with specific items for this test.
	 */
	private static Cart fillCartforTest1Cart() {
		Cart cart = new Cart();
		cart.add(new CashierItem(Catalog.BOOK.getCategory(), Catalog.BOOK.getLabel(), Catalog.BOOK.getPrice(), Catalog.BOOK.isImported()));
		cart.add(new CashierItem(Catalog.MUSIC_CD.getCategory(),Catalog.MUSIC_CD.getLabel(), Catalog.MUSIC_CD.getPrice(),Catalog.MUSIC_CD.isImported()));
		cart.add(new CashierItem(Catalog.CHOCOLATE_BAR.getCategory(),Catalog.CHOCOLATE_BAR.getLabel(), Catalog.CHOCOLATE_BAR.getPrice(), Catalog.CHOCOLATE_BAR.isImported()));
		return cart;
	}
	
	/**
	 * Pre-configured test for specific list of items
	 * 
	 * @return the Cart with specific items for this test.
	 */
	private static Cart fillCartforTest2Cart() {
		Cart cart = new Cart();
		cart.add(new CashierItem(Catalog.CHOCOLATE_BOX_10_IMP.getCategory(),Catalog.CHOCOLATE_BOX_10_IMP.getLabel(),Catalog.CHOCOLATE_BOX_10_IMP.getPrice(),Catalog.CHOCOLATE_BOX_10_IMP.isImported()));
		cart.add(new CashierItem(Catalog.PERFUME_4750_IMP.getCategory(),Catalog.PERFUME_4750_IMP.getLabel(), Catalog.PERFUME_4750_IMP.getPrice(), Catalog.PERFUME_4750_IMP.isImported()));
		return cart;

	}
	
	/**
	 * Pre-configured test for specific list of items
	 * 
	 * @return the Cart with specific items for this test.
	 */
	private static Cart fillCartforTest3Cart() {
		Cart cart = new Cart();
		cart.add(new CashierItem(Catalog.PERFUME_2799_IMP.getCategory(),Catalog.PERFUME_2799_IMP.getLabel(), Catalog.PERFUME_2799_IMP.getPrice(),Catalog.PERFUME_2799_IMP.isImported()));
		cart.add(new CashierItem(Catalog.PERFUME_1899.getCategory(),Catalog.PERFUME_1899.getLabel(), Catalog.PERFUME_1899.getPrice(),Catalog.PERFUME_1899.isImported()));
		cart.add(new CashierItem(Catalog.PACKET_HEADACHE_PILLS.getCategory(),Catalog.PACKET_HEADACHE_PILLS.getLabel(),Catalog.PACKET_HEADACHE_PILLS.getPrice(),Catalog.PACKET_HEADACHE_PILLS.isImported()));
		cart.add(new CashierItem(Catalog.CHOCOLATE_BOX_1125_IMP.getCategory(),Catalog.CHOCOLATE_BOX_1125_IMP.getLabel(),Catalog.CHOCOLATE_BOX_1125_IMP.getPrice(),Catalog.CHOCOLATE_BOX_1125_IMP.isImported()));
		return cart;
	}

}
