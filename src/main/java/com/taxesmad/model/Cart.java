package com.taxesmad.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple representation of a Cart containing 
 * a List of items to be bought 
 *  
 * @author Stefano Ferrante
 * 
 */
public class Cart  {
	private List<CashierItem>  items;
	
	//Operation used to update the cart items
	private enum Operations {
		increase, decrease 
	};
	
	public Cart() {
		items = new ArrayList<CashierItem>();
	}
	
	/**
	 * @return true if the list is empty false otherwise
	 */
	public boolean isEmpty() {
		return items.isEmpty();
	}
	
	/**
	 * Add an item to the cart, if the item is already present,
	 *  will increase the quantity of the item already present 
	 *  based on the quantity of the item in input.
	 * @param item to added
	 */
	public void add(CashierItem item) {
		if (items.contains(item)) {
			increaseItems(item);
			return;
		}
		items.add(item);
	}
	
	/**
	 * Remove an item from the list if present, 
	 * despite of the quantity specified in the item in input.
	 * @param item
	 */
	public void remove(CashierItem item) { 
		items.remove(item);
	}

	/**
	 * Decrease the quantity of an item in the list based on the
	 * specified quantity of the item in input.
	 * 
	 * @param item
	 */
	public void decreaseItems(CashierItem item) {
		updateCart(Operations.decrease,item);
	}
	
	/**
	 * Increase the quantity of an item in the list based on the specified quantity of the item in input.
	 * 
	 * @param item
	 */
	public void increaseItems(CashierItem item) {
		updateCart(Operations.increase, item);
	}
		
	/**
	 * Update the items contained in the cart accordingly to @see {@link Operations}
	 * In case an item quantity reaches 0 , it will be removed from the cart. 
	 * 
	 * @param op
	 * @param itemUp
	 */
	private void updateCart(Operations op, CashierItem itemUp) {
		CashierItem itemToBeRemoved=null;
		if (!items.contains(itemUp))
			return;
		for (CashierItem item : items) {
			if (item.equals(itemUp)) {
				switch (op) {
				case increase:
					item.increase(itemUp.getQuantity());
					break;
				case decrease:
					item.decrease(itemUp.getQuantity());
					if(item.getQuantity()==0)
						itemToBeRemoved = item;
					break;
				}
				break;
			}
			
		}
		if(itemToBeRemoved!= null)
			items.remove(itemToBeRemoved);
	}
	
	/**
	 * Return the list of items contained in the cart
	 * @return
	 */
	public List<CashierItem> getCartContent(){
		return items;
	}
	
	/**
	 * Count the items in the list, reading the quantity value for each item.
	 * @return
	 */
	public int itemsContained(){
		int total=0;
		for(CashierItem item : items) {
			total+= item.getQuantity();
		}
		return total;
	}
	
	

}
