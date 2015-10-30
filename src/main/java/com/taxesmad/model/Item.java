package com.taxesmad.model;

import java.math.BigDecimal;

public class Item {
	 public enum  ItemCategory {food,book,medical,generic};
	 
	 private boolean imp;
	 private ItemCategory cat;
	 private String label;
	 private BigDecimal price;
	 
	 public Item(ItemCategory cat,boolean imp,String label,BigDecimal price){
		 this.cat = cat;
		 this.imp = imp;
		 this.label = label;
		 this.price = price;
	 }
	 
	 public Item(ItemCategory cat,String label,BigDecimal price){
		 this.cat = cat;
		 this.label = label;
		 this.price = price;
	 }

	/**
	 * @return the imp
	 */
	public boolean isImp() {
		return imp;
	}

	/**
	 * @param imp the imp to set
	 */
	public void setImp(boolean imp) {
		this.imp = imp;
	}

	/**
	 * @return the cat
	 */
	public ItemCategory getCat() {
		return cat;
	}

	/**
	 * @param cat the cat to set
	 */
	public void setCat(ItemCategory cat) {
		this.cat = cat;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Item [imp=" + imp + ", cat=" + cat + ", label=" + label
				+ ", price=" + price + "]";
	}
	
	
}
