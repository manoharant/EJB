package net.learntechnology.service;

import java.util.List;

import javax.ejb.Local;

import net.learntechnology.persistence.entity.Customers;

@Local
public interface CustomerService {
    List<Customers> getCustomers();
    public Customers findByCusID(String cusId);
    List<Customers> findByCusName(String cusName);
    public Customers saveCustomer(Customers cusId);
}
