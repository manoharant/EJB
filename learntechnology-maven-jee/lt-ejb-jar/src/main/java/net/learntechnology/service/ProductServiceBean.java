package net.learntechnology.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import net.learntechnology.persistence.dao.ProductDAO;
import net.learntechnology.persistence.entity.Products;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Stateless
public class ProductServiceBean implements ProductService {
	private static Log log = LogFactory.getLog(ProductServiceBean.class);

	ProductDAO userDAO;

	@EJB
	public void setProductDAO(ProductDAO userDAO) {
		this.userDAO = userDAO;
	}

	public List<Products> getProducts() {
		System.out.println("ProductServiceBean#Inside#getProducts");
		return userDAO.getProducts();
	}

	public Products findByProductID(String prodCode) {
		System.out.println("ProductServiceBean#Inside#findByProductID");
		return userDAO.findByProductID(prodCode);
	}

	public List<Products> findByProductName(String prodName) {
		System.out.println("ProductServiceBean#Inside#findByProductName");
		return userDAO.findByProductName(prodName);
	}

	public Products saveProduct(Products prodCode) {
		System.out.println("ProductServiceBean#Inside#saveProduct");
		return userDAO.saveProduct(prodCode);
	}
}
