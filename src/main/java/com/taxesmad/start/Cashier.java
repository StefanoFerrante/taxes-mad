package com.taxesmad.start;

import java.math.BigDecimal;

import com.taxesmad.model.Cart;
import com.taxesmad.model.CashierItem;

/**
 * This class is responsible to collect all the items 
 * in the cart and calculate the total and total taxes for the receipt 
 * 
 * @author Stefano Ferrante
 *
 */
public class Cashier {
	/**
	 * Receive in input a Cart with the items the user want to buy, and return a String
	 * representing the receipt.
	 * 
	 * @param cart
	 * @return the receipt for the cart
	 */
	public String checkout(Cart cart){
		BigDecimal taxesTotal = new BigDecimal("0.00");
		BigDecimal total = new BigDecimal("0.00");
		StringBuffer recepit = new StringBuffer();
		for(CashierItem item : cart.getCartContent()){
			total = total.add(item.getPrice());
			taxesTotal = taxesTotal.add(item.getTaxesSales());
			recepit.append(item.prettyReceipt()+"\n");
		}
		recepit.append(String.format("Sales Taxes: %s \n",taxesTotal));
		recepit.append(String.format("Total: %s \n",total));
		return recepit.toString();
	}
	
	
	
}
