package com.taxesmad.model;

import java.math.BigDecimal;
/**
 * Base class to represent an item in the test
 * Evaluating all the attributes of the object make it unique in a Cart.
 * 
 * @author Stefano Ferrante
 *
 */
public class Item {
	 public enum  ItemCategory {food,book,medical,generic};
	 
	 private boolean imported;
	 private ItemCategory category;
	 private String label;
	 private BigDecimal price;
	 /**
	  * Configure an item 
	  * @param cat
	  * @param imp
	  * @param label
	  * @param price
	  */
	 public Item(ItemCategory cat,String label,BigDecimal price,boolean imp){
		 this.category = cat;
		 this.imported = imp;
		 this.label = label;
		 this.price = price;
	 }
	 
	@Override
	public String toString() {
		return "Item [imp=" + imported + ", cat=" + category + ", label=" + label + ", price=" + price + "]";
	}

	/**
	 * @return the imp
	 */
	public boolean isImported() {
		return imported;
	}

	/**
	 * @return the cat
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + (imported ? 1231 : 1237);
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (category != other.category)
			return false;
		if (imported != other.imported)
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}
	
	
}
