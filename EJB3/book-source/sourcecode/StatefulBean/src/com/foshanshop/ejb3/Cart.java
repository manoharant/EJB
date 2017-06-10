package com.foshanshop.ejb3;

import java.io.Serializable;
import java.util.List;

public interface Cart extends Serializable {
	 public void AddBuyItem(String productName);
	 public List<String> getBuyItem();
}
