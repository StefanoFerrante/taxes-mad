package com.taxesmad.test.items;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.taxesmad.model.Cart;
import com.taxesmad.model.Item;

public class CartTest {

	@Test
	public void addItem() {
		Cart cart = new Cart();
		assertTrue(cart.isEmpty());
		Item item = new Item(Item.ItemCategory.generic,"1 bottle of perfume at 18.99",new BigDecimal(18.99));
		cart.add(item);
		assertFalse(cart.isEmpty());
	}
	
	@Test
	public void retrieveItemsFromCart() {
		Cart cart = new Cart();
		assertTrue(cart.isEmpty());
		Item item = new Item(Item.ItemCategory.generic,"1 bottle of perfume at 18.99",new BigDecimal(18.99));
		cart.add(item);
		assertFalse(cart.isEmpty());
	}
	
	
	
	

}
