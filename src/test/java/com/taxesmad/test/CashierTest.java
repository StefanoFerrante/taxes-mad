package com.taxesmad.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.taxesmad.model.Cart;
import com.taxesmad.model.CashierItem;
import com.taxesmad.start.Cashier;

public class CashierTest {
	
	Cashier cashier = new Cashier();
	/**
	 * 1 book at 12.49
	 * 1 music CD at 14.99
     * 1 chocolate bar at 0.85
	 */
	@Test
	public void firstOrderTest() {
		Cart cart = new Cart();
		cart.add(new CashierItem(Catalog.BOOK.getCategory(),
				Catalog.BOOK.getLabel(), Catalog.BOOK.getPrice(),
				Catalog.BOOK.isImported()));
		cart.add(new CashierItem(
				Catalog.MUSIC_CD.getCategory(),
				Catalog.MUSIC_CD.getLabel(),
				Catalog.MUSIC_CD.getPrice(),
				Catalog.MUSIC_CD.isImported()));
		cart.add(new CashierItem(Catalog.CHOCOLATE_BAR.getCategory(),
				Catalog.CHOCOLATE_BAR.getLabel(),
				Catalog.CHOCOLATE_BAR.getPrice(),
				Catalog.CHOCOLATE_BAR.isImported()));
		System.out.println(cashier.checkout(cart));
	}
	
	/**
	 * 1 imported box of chocolates at 10.00
	 * 1 imported bottle of perfume at 47.50
	 */
	@Test
	public void secondOrderTest() {
		Cart cart = new Cart();
		cart.add(new CashierItem(Catalog.CHOCOLATE_BOX_10_IMP.getCategory(),
				Catalog.CHOCOLATE_BOX_10_IMP.getLabel(), Catalog.CHOCOLATE_BOX_10_IMP.getPrice(),
				Catalog.CHOCOLATE_BOX_10_IMP.isImported()));
		cart.add(new CashierItem(
				Catalog.PERFUME_4750_IMP.getCategory(),
				Catalog.PERFUME_4750_IMP.getLabel(),
				Catalog.PERFUME_4750_IMP.getPrice(),
				Catalog.PERFUME_4750_IMP.isImported()));
		System.out.println(cashier.checkout(cart));
	}
	
	/**
	 * 1 imported bottle of perfume at 27.99
	 * 1 bottle of perfume at 18.99
	 * 1 packet of headache pills at 9.75
	 * 1 box of imported chocolates at 11.25
	 */
	@Test
	public void thirdOrderTest() {
		Cart cart = new Cart();
		cart.add(new CashierItem(Catalog.PERFUME_2799_IMP.getCategory(),
				Catalog.PERFUME_2799_IMP.getLabel(), Catalog.PERFUME_2799_IMP.getPrice(),
				Catalog.PERFUME_2799_IMP.isImported()));
		cart.add(new CashierItem(Catalog.PERFUME_1899.getCategory(),
				Catalog.PERFUME_1899.getLabel(), Catalog.PERFUME_1899.getPrice(),
				Catalog.PERFUME_1899.isImported()));
		cart.add(new CashierItem(
				Catalog.PACKET_HEADACHE_PILLS.getCategory(),
				Catalog.PACKET_HEADACHE_PILLS.getLabel(),
				Catalog.PACKET_HEADACHE_PILLS.getPrice(),
				Catalog.PACKET_HEADACHE_PILLS.isImported()));
		cart.add(new CashierItem(
				Catalog.CHOCOLATE_BOX_1125_IMP.getCategory(),
				Catalog.CHOCOLATE_BOX_1125_IMP.getLabel(),
				Catalog.CHOCOLATE_BOX_1125_IMP.getPrice(),
				Catalog.CHOCOLATE_BOX_1125_IMP.isImported()));
		System.out.println(cashier.checkout(cart));
	}


}
