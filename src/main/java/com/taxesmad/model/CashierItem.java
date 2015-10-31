package com.taxesmad.model;

import java.math.BigDecimal;

import com.taxesmad.util.TaxesEvaluator;

public class CashierItem extends Item {
	private int quantity = 1;

	public CashierItem(ItemCategory cat, String label, BigDecimal price,
			boolean imp) {
		super(cat, label, price, imp);
	}

	public void increase(int quUpdate) {
		quantity += quUpdate;
	}

	public void decrease(int quUpdate) {
		if (quantity <= quUpdate) {
			quantity = 0;
			return;
		}
		this.quantity -= quUpdate;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	@Override
	public BigDecimal getPrice() {
		return TaxesEvaluator.priceWithTaxes(this.getCategory(),super.getPrice(), this.isImported()).multiply(new BigDecimal(quantity));
	}
	
	public BigDecimal getTaxSales(){
		return TaxesEvaluator.salesTaxes(this.getCategory(),super.getPrice(), this.isImported()).multiply(new BigDecimal(quantity));
	}

	public String prettyRecepit() {
		return String.format("> %1d %2s %3s %4s", 
				this.quantity,
				this.getLabel(), 
				this.getPrice().multiply(new BigDecimal(quantity)),
				((this.isImported()) ? "(Imported)" : "")
				);
	}

}
