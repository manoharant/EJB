package net.learntechnology.service;

import java.util.List;

import javax.ejb.Local;

import net.learntechnology.persistence.entity.Products;

@Local
public interface ProductService {
	List<Products> getProducts();

	public Products findByProductID(String prodId);

	List<Products> findByProductName(String prodName);

	public Products saveProduct(Products prodId);
}
