package com.taxesmad.test;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import com.taxesmad.model.Cart;
import com.taxesmad.model.CashierItem;
import com.taxesmad.util.Catalog;

public class TaxesTest {
	/**
	 * Test case calculating the taxes for a local Book
	 */
	@Test
	public void bookTaxesTest() {
		Cart cart = new Cart();
		assertTrue(cart.isEmpty());
		CashierItem item = new CashierItem(Catalog.BOOK.getCategory(),
				Catalog.BOOK.getLabel(), Catalog.BOOK.getPrice(),
				Catalog.BOOK.isImported());
		System.out.println("Item price BOOK:" + item.getPrice().doubleValue());
		Assert.assertEquals(Catalog.BOOK.getPrice().doubleValue(), item
				.getPrice().doubleValue(), 0);
	}
	
	/**
	 * Test case calculating the taxes for an imported Food
	 */
	@Test
	public void importedFoodTaxesTest() {
		Cart cart = new Cart();
		assertTrue(cart.isEmpty());
		CashierItem item = new CashierItem(
				Catalog.CHOCOLATE_BOX_10_IMP.getCategory(),
				Catalog.CHOCOLATE_BOX_10_IMP.getLabel(),
				Catalog.CHOCOLATE_BOX_10_IMP.getPrice(),
				Catalog.CHOCOLATE_BOX_10_IMP.isImported());
		System.out.println("Item price CHOCOLATE BOX IMP:"
				+ item.getPrice().doubleValue());
		Assert.assertEquals(10.50, item.getPrice().doubleValue(), 0);
	}
	
	/**
	 * Test case calculating the taxes for a local Food
	 */
	@Test
	public void localFoodTaxesTest() {
		Cart cart = new Cart();
		assertTrue(cart.isEmpty());
		CashierItem item = new CashierItem(Catalog.CHOCOLATE_BAR.getCategory(),
				Catalog.CHOCOLATE_BAR.getLabel(),
				Catalog.CHOCOLATE_BAR.getPrice(),
				Catalog.CHOCOLATE_BAR.isImported());
		System.out.println("Item price CHOCOLATE BAR:"
				+ item.getPrice().doubleValue());
		Assert.assertEquals(Catalog.CHOCOLATE_BAR.getPrice().doubleValue(),
				item.getPrice().doubleValue(), 0);
	}

	/**
	 * Test case calculating the taxes for a local Medical
	 */
	@Test
	public void medicalTaxesTest() {
		Cart cart = new Cart();
		assertTrue(cart.isEmpty());
		CashierItem item = new CashierItem(
				Catalog.PACKET_HEADACHE_PILLS.getCategory(),
				Catalog.PACKET_HEADACHE_PILLS.getLabel(),
				Catalog.PACKET_HEADACHE_PILLS.getPrice(),
				Catalog.PACKET_HEADACHE_PILLS.isImported());
		System.out.println("Item price PACKET HEADACHE PILLS:"
				+ item.getPrice().doubleValue());
		Assert.assertEquals(Catalog.PACKET_HEADACHE_PILLS.getPrice().doubleValue(),
				item.getPrice().doubleValue(), 0);
	}
	
	/**
	 * Test case calculating the taxes for a local Generic
	 */
	@Test
	public void localGeneric1499TaxesTest() {
		Cart cart = new Cart();
		assertTrue(cart.isEmpty());
		CashierItem item = new CashierItem(
				Catalog.MUSIC_CD.getCategory(),
				Catalog.MUSIC_CD.getLabel(),
				Catalog.MUSIC_CD.getPrice(),
				Catalog.MUSIC_CD.isImported());
		System.out.println("Item price MUSIC CD:" + item.getPrice().doubleValue());
		Assert.assertEquals(16.49,item.getPrice().doubleValue(), 0);
	}
	
	/**
	 * Test case calculating the taxes for a local Generic
	 */
	@Test
	public void localGenericTaxesTest() {
		Cart cart = new Cart();
		assertTrue(cart.isEmpty());
		CashierItem item = new CashierItem(
				Catalog.PERFUME_1899.getCategory(),
				Catalog.PERFUME_1899.getLabel(),
				Catalog.PERFUME_1899.getPrice(),
				Catalog.PERFUME_1899.isImported());
		System.out.println("Item price PERFUME:" + item.getPrice().doubleValue());
		Assert.assertEquals(20.89,item.getPrice().doubleValue(), 0);
	}
	
	/**
	 * Test case calculating the taxes for a imported Generic
	 */
	@Test
	public void importedGenericTaxesTest() {
		Cart cart = new Cart();
		assertTrue(cart.isEmpty());
		CashierItem item = new CashierItem(
				Catalog.PERFUME_4750_IMP.getCategory(),
				Catalog.PERFUME_4750_IMP.getLabel(),
				Catalog.PERFUME_4750_IMP.getPrice(),
				Catalog.PERFUME_4750_IMP.isImported());
		System.out.println("Item price PERFUME IMP:" + item.getPrice().doubleValue());
		Assert.assertEquals(54.65,item.getPrice().doubleValue(), 0);
	}
	
	/**
	 * Test case calculating the taxes for a imported Generic
	 */
	@Test
	public void importedGeneric2799TaxesTest() {
		Cart cart = new Cart();
		assertTrue(cart.isEmpty());
		CashierItem item = new CashierItem(
				Catalog.PERFUME_2799_IMP.getCategory(),
				Catalog.PERFUME_2799_IMP.getLabel(),
				Catalog.PERFUME_2799_IMP.getPrice(),
				Catalog.PERFUME_2799_IMP.isImported());
		System.out.println("Item price PERFUME IMP:" + item.getPrice().doubleValue());
		Assert.assertEquals(32.19,item.getPrice().doubleValue(), 0);
	}
	
	/**
	 * Test case calculating the taxes for a imported Food
	 */
	@Test
	public void importedFood1125TaxesTest() {
		Cart cart = new Cart();
		assertTrue(cart.isEmpty());
		CashierItem item = new CashierItem(
				Catalog.CHOCOLATE_BOX_1125_IMP.getCategory(),
				Catalog.CHOCOLATE_BOX_1125_IMP.getLabel(),
				Catalog.CHOCOLATE_BOX_1125_IMP.getPrice(),
				Catalog.CHOCOLATE_BOX_1125_IMP.isImported());
		System.out.println("Item price CHOCOLATE BOX:" + item.getPrice().doubleValue());
		Assert.assertEquals(11.85,item.getPrice().doubleValue(), 0);
	}
	
	/**
	 * Test case calculating the taxes for a imported Food
	 */
	@Test
	public void imported2Food1125TaxesTest() {
		Cart cart = new Cart();
		assertTrue(cart.isEmpty());
		CashierItem item = new CashierItem(
				Catalog.CHOCOLATE_BOX_1125_IMP.getCategory(),
				Catalog.CHOCOLATE_BOX_1125_IMP.getLabel(),
				Catalog.CHOCOLATE_BOX_1125_IMP.getPrice(),
				Catalog.CHOCOLATE_BOX_1125_IMP.isImported());
		item.increase(1);
		System.out.println("Item price CHOCOLATE BOX:" + item.getPrice().doubleValue());
		Assert.assertEquals(23.70,item.getPrice().doubleValue(), 0);
		System.out.println("Recepit"+item.prettyReceipt());
	}
	
	
	
}
