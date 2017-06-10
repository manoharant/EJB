package net.learntechnology.persistence.dao;

import java.util.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.learntechnology.persistence.entity.Customers;

@Stateless
public class CustomerDAOBean implements CustomerDAO {
	private static Log log = LogFactory.getLog(CustomerDAOBean.class);

	private EntityManager em;

	@PersistenceContext(unitName = "OurEntityManager")
	public void setEm(EntityManager em) {
		this.em = em;
	}

	public List<Customers> getCustomers() {
		System.out.println("CustomerDAOBean#Inside @getCustomers");
		List<Customers> customers = this.em.createQuery(
				"select cust from Customers cust order by cust.customerNumber")
				.getResultList();
		System.out.println("CustomerDAOBean#getCustomers#returnSize#"
				+ customers.size());
		return customers;
	}

	public Customers saveUser(Customers customers) {
		System.out.println("CustomerDAOBean#Inside @saveUser");
		this.em.persist(customers);
		this.em.flush();
		return customers;
	}

	public Customers findByCusID(String cusId) {
		System.out.println("CustomerDAOBean#Inside @findByCusID");
		System.out.println("CustomerDAOBean#Input CustomerID# " + cusId);
		Query query = em
				.createQuery("select cust FROM Customers cust  WHERE cust.customerNumber=:cusID");
		query.setParameter("cusID", Integer.parseInt(cusId));
		List<Customers> obs = query.getResultList();
		Customers customer = (Customers) obs.get(0);
		return customer;
	}

	public List<Customers> findByCusName(String cusName) {
		System.out.println("CustomerDAOBean#Inside @findByCusName");
		System.out.println("CustomerDAOBean#Input findByCusName :" + cusName);
		List<Customers> customers = this.em
				.createQuery(
						"select cust from Customers cust where cust.customerName like :keyword")
				.setParameter("keyword", "%" + cusName + "%").getResultList();
		return customers;
	}
}
