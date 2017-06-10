package com.foshanshop.ejb3.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import com.foshanshop.ejb3.Cart;

@SuppressWarnings("serial")
@Stateful
@Remote(Cart.class)
public class CartBean implements Cart{
	private List<String> buyitem = new ArrayList<String>();
	
	public void AddBuyItem(String productName) {
		buyitem.add(productName);
	}

	public List<String> getBuyItem() {
		return buyitem;
	}

}
