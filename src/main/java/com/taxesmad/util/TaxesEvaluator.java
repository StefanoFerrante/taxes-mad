package com.taxesmad.util;

import java.math.BigDecimal;

import com.taxesmad.model.Item.ItemCategory;
/**
 * Basic sales tax is applicable at a rate of 10% 
 * on all goods, except books, food, and medical products that are exempt. 
 * Import duty is an additional sales tax applicable on all imported goods 
 * at a rate of 5%, with no exemptions.
 * 
 * @author Stefano Ferrante
 *
 */
public class TaxesEvaluator {
	private static final BigDecimal ROUND_RULE = new BigDecimal("0.05"); 
	private static final BigDecimal TAX_IMPORTED = new BigDecimal("5");
	
	
	
	
	
	public static BigDecimal priceWithTaxes(ItemCategory category,BigDecimal price,boolean imported){
		return salesTaxes(category,price,imported).add(price);
	}
	
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
