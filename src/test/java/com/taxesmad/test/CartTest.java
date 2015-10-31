package com.taxesmad.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.taxesmad.model.Cart;
import com.taxesmad.model.CashierItem;

public class CartTest {

	@Test
	public void addItemTest() {
		Cart cart = new Cart();
		assertTrue(cart.isEmpty());
		CashierItem item = new CashierItem(Catalog.BOOK.getCategory(),Catalog.BOOK.getLabel(),Catalog.BOOK.getPrice(),Catalog.BOOK.isImported());
		cart.add(item);
		assertFalse(cart.isEmpty());
	}
	
	@Test
	public void addItemDuplicatedAndQuantityIncreased() {
		Cart cart = new Cart();
		CashierItem item1 = new CashierItem(Catalog.BOOK.getCategory(),Catalog.BOOK.getLabel(),Catalog.BOOK.getPrice(),Catalog.BOOK.isImported());
		CashierItem item2 = new CashierItem(Catalog.BOOK.getCategory(),Catalog.BOOK.getLabel(),Catalog.BOOK.getPrice(),Catalog.BOOK.isImported());
		item2.increase(2);
		cart.add(item1);
		cart.add(item2);
		List<CashierItem> cont = cart.getCartContent();
		assertTrue(cont.size()==1);
		assertTrue(cont.get(0).getQuantity()==4);
	}
	
	
	@Test
	public void removeAndDecrease() {
		Cart cart = new Cart();
		CashierItem item1 = new CashierItem(Catalog.BOOK.getCategory(),Catalog.BOOK.getLabel(),Catalog.BOOK.getPrice(),Catalog.BOOK.isImported());
		CashierItem item2 = new CashierItem(Catalog.CHOCOLATE_BOX_10_IMP.getCategory(),Catalog.CHOCOLATE_BOX_10_IMP.getLabel(),Catalog.CHOCOLATE_BOX_10_IMP.getPrice(),Catalog.CHOCOLATE_BOX_10_IMP.isImported());
		item2.increase(2);
		cart.add(item1);
		cart.add(item2);
		List<CashierItem> cont = cart.getCartContent();
		assertTrue(cont.size()==2);
		cart.remove(item1);
		assertFalse(cart.isEmpty());
		assertTrue(cont.size()==1);
		CashierItem item3 = new CashierItem(Catalog.CHOCOLATE_BOX_10_IMP.getCategory(),Catalog.CHOCOLATE_BOX_10_IMP.getLabel(),Catalog.CHOCOLATE_BOX_10_IMP.getPrice(),Catalog.CHOCOLATE_BOX_10_IMP.isImported());
		item3.increase(1);
		cart.decreaseItems(item3);
		assertFalse(cart.isEmpty());
		cart.decreaseItems(item3);
		assertTrue(cart.isEmpty());
				
	}
	
	
	
	

}
