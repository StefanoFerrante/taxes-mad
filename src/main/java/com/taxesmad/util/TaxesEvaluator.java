package com.taxesmad.util;

import java.math.BigDecimal;

import com.taxesmad.model.Item.ItemCategory;
/**
 * The class contains 2 static methods to evaluate the taxes based on the attributes in input.
 * 
 * @author Stefano Ferrante
 *
 */
public class TaxesEvaluator {
	private static final BigDecimal ROUND_RULE = new BigDecimal("0.05"); 
	private static final BigDecimal TAX_IMPORTED = new BigDecimal("5");
	
	/**
	 * Based on the attributes passed in input return the price + taxes.
	 * 	
	 * @param category
	 * @param price
	 * @param imported
	 * @return the price with the taxes added.
	 */
	public static BigDecimal priceWithTaxes(ItemCategory category,BigDecimal price,boolean imported){
		return salesTaxes(category,price,imported).add(price);
	}
	
	/**
	 * Based on the attributes passed in input return the taxes to be applied.
	 * 	
	 * @param category
	 * @param price
	 * @param imported
	 * @return the price with the taxes added.
	 */
	public static BigDecimal salesTaxes(ItemCategory category,BigDecimal price,boolean imported){
		BigDecimal baseTaxPercentage=null;
		switch (category) {
		case book:
		case food:
		case medical:
			baseTaxPercentage = new BigDecimal("0.00");
			break;
		default:
			baseTaxPercentage = new BigDecimal("10.00");
			break;
		}
		if(imported)
			baseTaxPercentage = baseTaxPercentage.add(TAX_IMPORTED);
		
		if(baseTaxPercentage.doubleValue()==0.00)
			return baseTaxPercentage;
		
		BigDecimal priceTax = price.multiply(baseTaxPercentage).divide(new BigDecimal(100));
		priceTax = priceTax.divide(ROUND_RULE);
		priceTax = new BigDecimal(Math.ceil(priceTax.doubleValue()));
		priceTax = priceTax.multiply(ROUND_RULE);
		return priceTax;

	}
	
	
	
	
}
