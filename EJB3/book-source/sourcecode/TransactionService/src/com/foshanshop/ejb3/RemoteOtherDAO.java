package com.foshanshop.ejb3;

import com.foshanshop.ejb3.bean.Product;

public interface RemoteOtherDAO{
	public void systemException();
	public void required();
	public Product notSupported(int productid);
	public void requirednew();
	public Product support(int productid);
	public void mandatory();
	public Product never(int productid);
}
