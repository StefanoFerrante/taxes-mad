package com.taxesmad.util;

import java.math.BigDecimal;

import com.taxesmad.model.CashierItem;
import com.taxesmad.model.Item;
import com.taxesmad.model.Item.ItemCategory;

/**
1 book at 12.49
1 music CD at 14.99
1 chocolate bar at 0.85
1 imported box of chocolates at 10.00
1 imported bottle of perfume at 47.50
1 imported bottle of perfume at 27.99
1 bottle of perfume at 18.99
1 packet of headache pills at 9.75
1 box of imported chocolates at 11.25
 *
 *
 * Utility enumeration to store the products for test
 *
 */


public enum Catalog {
	BOOK(ItemCategory.book,"Book",new BigDecimal("12.49"),false,"1"),
	MUSIC_CD(ItemCategory.generic,"Music CD",new BigDecimal("14.99"),false,"2"),
	CHOCOLATE_BAR(ItemCategory.food,"Chocolate Bar",new BigDecimal("0.85"),false,"3"),
	CHOCOLATE_BOX_10_IMP(ItemCategory.food,"Box of Chocolates",new BigDecimal("10.00"),true,"4"),
	PERFUME_4750_IMP(ItemCategory.generic,"Bottle of Perfume",new BigDecimal("47.50"),true,"5"),
	PERFUME_2799_IMP(ItemCategory.generic,"Bottle of Perfume",new BigDecimal("27.99"),true,"6"),
	PERFUME_1899(ItemCategory.generic,"Bottle of Perfume",new BigDecimal("18.99"),false,"7"),
	PACKET_HEADACHE_PILLS(ItemCategory.medical,"Packet of Headache pills",new BigDecimal("9.75"),false,"8"),
	CHOCOLATE_BOX_1125_IMP(ItemCategory.food,"Box of Chocolates",new BigDecimal("11.25"),true,"9"),
	;
	
	private ItemCategory category;
	private String label;
	private BigDecimal price;
	private boolean imported;
	private String code;
	
	private Catalog(Item.ItemCategory category ,String label,BigDecimal price,boolean imported,String code){
		this.category=category;
		this.label=label;
		this.price=price;
		this.imported=imported;
		this.code = code;
	}

	/**
	 * Return a CashierItem to be added to the Cart. 
	 * 
	 * @param code
	 * @return
	 */
	public static CashierItem retrieveFromCatalog(String code){
		for(Catalog item : Catalog.values()){
			if(item.getCode().equals(code))
				return new CashierItem(item.getCategory(),item.getLabel() , item.getPrice(), item.isImported());
		}
		return null;
	}
	
	/**
	 * @return the category
	 */
	public ItemCategory getCategory() {
		return category;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @return if imported product
	 */
	public boolean isImported() {
		return imported;
	}


	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

}
