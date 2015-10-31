package com.taxesmad.test.items;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import com.taxesmad.model.Cart;
import com.taxesmad.model.CashierItem;

public class TaxesTest {
	
	
	@Test
	public void bookTaxesTest() {
		Cart cart = new Cart();
		assertTrue(cart.isEmpty());
		CashierItem item = new CashierItem(Catalog.BOOK.getCategory(),Catalog.BOOK.getLabel(),Catalog.BOOK.getPrice(),Catalog.BOOK.isImported());
		System.out.println("Item price BOOK:"+item.getPrice().doubleValue());
		Assert.assertEquals(Catalog.BOOK.getPrice().doubleValue(), item.getPrice().doubleValue(),0);
	}
	
	@Test
	public void importedFoodTaxesTest() {
		Cart cart = new Cart();
		assertTrue(cart.isEmpty());
		CashierItem item = new CashierItem(Catalog.CHOCOLATE_BOX_10_IMP.getCategory(),Catalog.CHOCOLATE_BOX_10_IMP.getLabel(),Catalog.CHOCOLATE_BOX_10_IMP.getPrice(),Catalog.CHOCOLATE_BOX_10_IMP.isImported());
		System.out.println("Item price CHOCOLATE BOX IMP:"+item.getPrice().doubleValue());
		Assert.assertEquals(10.50, item.getPrice().doubleValue(),0);
	}
	
	@Test
	public void localFoodTaxesTest() {
		Cart cart = new Cart();
		assertTrue(cart.isEmpty());
		CashierItem item = new CashierItem(Catalog.CHOCOLATE_BAR.getCategory(),Catalog.CHOCOLATE_BAR.getLabel(),Catalog.CHOCOLATE_BAR.getPrice(),Catalog.CHOCOLATE_BAR.isImported());
		System.out.println("Item price CHOCOLATE BAR:"+item.getPrice().doubleValue());
		Assert.assertEquals(Catalog.CHOCOLATE_BAR.getPrice().doubleValue(), item.getPrice().doubleValue(),0);
	}
	

}
