package com.taxesmad.model;

import java.math.BigDecimal;

import com.taxesmad.util.TaxesEvaluator;

/**
 * Extends the simple Item object adding quantity and the print for the receipt.
 * Override the price methods to include taxes in the price.
 * 
 * @author Stefano Ferrante
 *
 */
public class CashierItem extends Item {
	//When an item is created the default quantity is 1.
	private int quantity = 1;
	
	/**
	 * 
	 * @param cat Category of the item
	 * @param label Label describing the item
	 * @param price Price of the item
	 * @param imp flag defining if the item is imported or not.
	 */
	public CashierItem(ItemCategory cat, String label, BigDecimal price,
			boolean imp) {
		super(cat, label, price, imp);
	}
	
	
	/**
	 * Increase the items to be purchased
	 * @param quUpdate
	 */
	public void increase(int quUpdate) {
		quantity += quUpdate;
	}
	
	/**
	 * Decrease the items to be purchased, avoiding negative values.
	 * 
	 * @param quUpdate
	 */
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
	/**
	 * Include taxes to the standard price of an item, the price is calculated based on the quantity as well.
	 */
	@Override
	public BigDecimal getPrice() {
		return TaxesEvaluator.priceWithTaxes(this.getCategory(),super.getPrice(), this.isImported()).multiply(new BigDecimal(quantity));
	}
	
	/**
	 * Return only the taxes sales to be paid for this specific item, the value is calculated on the quantity as well.  
	 * @return taxes for the item
	 */
	public BigDecimal getTaxesSales(){
		return TaxesEvaluator.salesTaxes(this.getCategory(),super.getPrice(), this.isImported()).multiply(new BigDecimal(quantity));
	}
	
	/**
	 * A formatted String to represent the item in the receipt
	 * 
	 * @return
	 */
	public String prettyReceipt() {
		return String.format("> %1d %2s %3s %4s", 
				this.quantity,
				this.getLabel(), 
				this.getPrice(),
				((this.isImported()) ? "(Imported)" : "")
				);
	}

}
