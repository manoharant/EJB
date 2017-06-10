package net.learntechnology.persistence.dao;

import java.util.List;

import net.learntechnology.persistence.entity.Customers;

public interface CustomerDAO extends DAO {
	public List<Customers> getCustomers();

	public Customers saveUser(Customers cust);

	public Customers findByCusID(String cusId);

	public List<Customers> findByCusName(String cusName);
}
