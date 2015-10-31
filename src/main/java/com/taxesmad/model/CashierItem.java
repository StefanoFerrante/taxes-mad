package com.taxesmad.model;

import java.math.BigDecimal;

import com.taxesmad.util.TaxesEvaluator;

public class CashierItem extends Item {
	private int quantity=1;
	
	public CashierItem(ItemCategory cat,String label,BigDecimal price,boolean imp) {
		super(cat,label,price,imp);
	}
	
	public void increase(int quUpdate){
		quantity+=quUpdate;
	}
	
	public void decrease(int  quUpdate){
		if(quantity<=quUpdate){
			quantity=0;
			return;
		}
		this.quantity-=quUpdate;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	
	@Override
	public BigDecimal getPrice() {
		return TaxesEvaluator.evaluateTaxes(this.getCategory(),super.getPrice(),this.isImported());
	}
	
	
	
	
	
}
