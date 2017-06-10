package net.learntechnology.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import net.learntechnology.persistence.dao.CustomerDAO;
import net.learntechnology.persistence.entity.Customers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Stateless
public class CustomerServiceBean implements CustomerService {
	private static Log log = LogFactory.getLog(CustomerServiceBean.class);

	CustomerDAO userDAO;

	@EJB
	public void setCustomerDAO(CustomerDAO userDAO) {
		this.userDAO = userDAO;
	}

	public List<Customers> getCustomers() {
		System.out.println("CustomerServiceBean#Inside#getCustomers");
		return userDAO.getCustomers();
	}

	public Customers findByCusID(String cusId) {
		System.out.println("CustomerServiceBean#Inside#findByCusID");
		return userDAO.findByCusID(cusId);
	}

	public List<Customers> findByCusName(String cusName) {
		System.out.println("CustomerServiceBean#Inside#findByCusName");
		return userDAO.findByCusName(cusName);
	}

	public Customers saveCustomer(Customers cusId) {
		System.out.println("CustomerServiceBean#Inside#saveCustomer");
		return userDAO.saveUser(cusId);
	}
}
