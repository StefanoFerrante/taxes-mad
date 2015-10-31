package com.taxesmad.start;

import java.math.BigDecimal;

import com.taxesmad.model.Cart;
import com.taxesmad.model.CashierItem;

public class Cashier {
	
	public String checkout(Cart cart){
		BigDecimal taxesTotal = new BigDecimal("0.00");
		BigDecimal total = new BigDecimal("0.00");
		StringBuffer recepit = new StringBuffer();
		for(CashierItem item : cart.getCartContent()){
			total = total.add(item.getPrice());
			taxesTotal = taxesTotal.add(item.getTaxSales());
			recepit.append(item.prettyRecepit()+"\n");
		}
		recepit.append(String.format("Sales Taxes: %s \n",taxesTotal));
		recepit.append(String.format("Total: %s \n",total));
		return recepit.toString();
	}
	
	
	
}
