package net.learntechnology.persistence.dao;

import net.learntechnology.persistence.entity.Products;
import java.util.List;

public interface ProductDAO extends DAO {
	public List<Products> getProducts();

	public Products saveProduct(Products prod);

	public Products findByProductID(String prodId);

	public List<Products> findByProductName(String prodName);
}
