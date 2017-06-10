package net.learntechnology.persistence.dao;

import java.util.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.learntechnology.persistence.entity.Products;

@Stateless
public class ProductDAOBean implements ProductDAO {
	private static Log log = LogFactory.getLog(ProductDAOBean.class);

	private EntityManager em;

	@PersistenceContext(unitName = "OurEntityManager")
	public void setEm(EntityManager em) {
		this.em = em;
	}

	public List<Products> getProducts() {
		System.out.println("ProductDAOBean#Inside @getProducts");
		List<Products> prodomers = this.em.createQuery(
				"select prod from Products prod order by prod.productcode")
				.getResultList();
		System.out.println("ProductDAOBean#getProducts#returnSize#"
				+ prodomers.size());
		return prodomers;
	}

	public Products saveProduct(Products product) {
		System.out.println("ProductDAOBean#Inside @saveProduct");
		this.em.persist(product);
		this.em.flush();
		return product;
	}

	public Products findByProductID(String prodId) {
		System.out.println("ProductDAOBean#Inside @findByProductID");
		System.out.println("ProductDAOBean#Input ProductID# " + prodId);
		Query query = em
				.createQuery("select prod FROM Products prod  WHERE prod.productcode=:prodID");
		query.setParameter("prodID", prodId);
		List<Products> obs = query.getResultList();
		Products prodomer = (Products) obs.get(0);
		return prodomer;
	}

	public List<Products> findByProductName(String prodName) {
		System.out.println("ProductDAOBean#Inside @findByProductName");
		System.out.println("ProductDAOBean#Input findByProductName :" + prodName);
		List<Products> prodomers = this.em
				.createQuery(
						"select prod from Products prod where prod.productname like :keyword")
				.setParameter("keyword", "%" + prodName + "%").getResultList();
		return prodomers;
	}
}
