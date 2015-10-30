package com.taxesmad.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List items; 
	
	public Cart(){
		items = new ArrayList();
	}
	
	public boolean isEmpty(){
		return items.isEmpty();
	}
	
	public void add(Item item) {
		items.add(item);
	}
	
	
	
	
	
	
	
	

}
