package com.aam.jaxws.server.customer;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.xml.ws.BindingType;

import net.learntechnology.persistence.entity.Customers;
import net.learntechnology.service.CustomerService;

import com.aam.jaxws.server.AddCustomerRequestCustomerDetail;
import com.aam.jaxws.server.CustomerDetail;
import com.aam.jaxws.server.ObjectFactory;

@WebService(endpointInterface = "com.aam.jaxws.server.customer.CustomerManagement", serviceName = "CustomerManagementService", targetNamespace = "http://com.aam.jaxws.server.customer/")
@BindingType(value = "http://java.sun.com/xml/ns/jaxws/2003/05/soap/bindings/HTTP/")
@Stateless
public class CustomerManagementService implements CustomerManagement {
	@EJB
	public CustomerService customerDAO;

	public CustomerDetail findCustomerByID(String customerID) {

		System.out
				.println("Inside service call @CustomerManagementService#findCustomerByID");
		ObjectFactory theObjFactory = new ObjectFactory();

		Customers cust = customerDAO.findByCusID(customerID);
		CustomerDetail custDet = new CustomerDetail();
		custDet.setCustomerNumber(cust.getCustomerNumber());
		custDet.setCustomerName(cust.getCustomerName());
		custDet.setContactLastName(cust.getContactLastName());
		custDet.setContactFirstName(cust.getContactFirstName());
		custDet.setPhone(cust.getPhone());
		custDet.setAddressLine1(cust.getAddressLine1());
		custDet.setAddressLine2(theObjFactory
				.createCustomerDetailAddressLine2(cust.getAddressLine2()));
		custDet.setCity(cust.getCity());
		custDet.setState(theObjFactory.createCustomerDetailState(cust
				.getState()));
		custDet.setPostalCode(theObjFactory.createCustomerDetailPostalCode(cust
				.getPostalCode()));
		custDet.setCountry(cust.getCountry());
		custDet.setSalesRepEmployeeNumber(theObjFactory
				.createCustomerDetailSalesRepEmployeeNumber(cust
						.getSalesRepEmployeeNumber()));
		custDet.setCreditLimit(theObjFactory
				.createCustomerDetailCreditLimit(cust.getCreditLimit()));

		return custDet;
	}

	public List<CustomerDetail> getCustomers() {
		System.out
				.println("Inside service call @CustomerManagementService#getCustomers");
		ObjectFactory theObjFactory = new ObjectFactory();
		CustomerDetail custDet = null;
		Customers cust = null;
		List<Customers> custList = customerDAO.getCustomers();
		System.out.println("Customer List size = " + custList.size());
		List<CustomerDetail> respList = new ArrayList<CustomerDetail>();
		for (int i = 0; i < custList.size(); i++) {
			custDet = new CustomerDetail();
			cust = custList.get(i);
			custDet.setCustomerNumber(cust.getCustomerNumber());
			custDet.setCustomerName(cust.getCustomerName());
			custDet.setContactLastName(cust.getContactLastName());
			custDet.setContactFirstName(cust.getContactFirstName());
			custDet.setPhone(cust.getPhone());
			custDet.setAddressLine1(cust.getAddressLine1());
			custDet.setAddressLine2(theObjFactory
					.createCustomerDetailAddressLine2(cust.getAddressLine2()));
			custDet.setCity(cust.getCity());
			custDet.setState(theObjFactory.createCustomerDetailState(cust
					.getState()));
			custDet.setPostalCode(theObjFactory
					.createCustomerDetailPostalCode(cust.getPostalCode()));
			custDet.setCountry(cust.getCountry());
			custDet.setSalesRepEmployeeNumber(theObjFactory
					.createCustomerDetailSalesRepEmployeeNumber(cust
							.getSalesRepEmployeeNumber()));
			custDet.setCreditLimit(theObjFactory
					.createCustomerDetailCreditLimit(cust.getCreditLimit()));
			respList.add(custDet);
		}
		return respList;
	}

	public List<CustomerDetail> findCustomerByName(String customerName) {
		System.out
				.println("Inside service call @CustomerManagementService#findCustomerByName");
		ObjectFactory theObjFactory = new ObjectFactory();
		CustomerDetail custDet = null;
		Customers cust = null;
		List<Customers> custList = customerDAO.findByCusName(customerName);
		System.out
				.println("CustomerManagementService@findCustomerByName@Returned List size:"
						+ custList.size());
		List<CustomerDetail> respList = new ArrayList<CustomerDetail>();
		for (int i = 0; i < custList.size(); i++) {
			custDet = new CustomerDetail();
			cust = custList.get(i);
			custDet.setCustomerNumber(cust.getCustomerNumber());
			custDet.setCustomerName(cust.getCustomerName());
			custDet.setContactLastName(cust.getContactLastName());
			custDet.setContactFirstName(cust.getContactFirstName());
			custDet.setPhone(cust.getPhone());
			custDet.setAddressLine1(cust.getAddressLine1());
			custDet.setAddressLine2(theObjFactory
					.createCustomerDetailAddressLine2(cust.getAddressLine2()));
			custDet.setCity(cust.getCity());
			custDet.setState(theObjFactory.createCustomerDetailState(cust
					.getState()));
			custDet.setPostalCode(theObjFactory
					.createCustomerDetailPostalCode(cust.getPostalCode()));
			custDet.setCountry(cust.getCountry());
			custDet.setSalesRepEmployeeNumber(theObjFactory
					.createCustomerDetailSalesRepEmployeeNumber(cust
							.getSalesRepEmployeeNumber()));
			custDet.setCreditLimit(theObjFactory
					.createCustomerDetailCreditLimit(cust.getCreditLimit()));
			respList.add(custDet);
		}
		return respList;
	}

	public boolean addCustomer(AddCustomerRequestCustomerDetail StoreCustomer) {
		System.out
				.println("Inside service call @CustomerManagementService#addCustomer");
		Customers cust = new Customers();

		cust.setCustomerName(StoreCustomer.getCustomerName());
		cust.setContactLastName(StoreCustomer.getContactLastName());
		cust.setContactFirstName(StoreCustomer.getContactFirstName());
		cust.setPhone(StoreCustomer.getPhone());
		cust.setAddressLine1(StoreCustomer.getAddressLine1());
		cust.setAddressLine2(StoreCustomer.getAddressLine2().getValue());
		cust.setCity(cust.getCity());
		cust.setState(StoreCustomer.getState().getValue());
		cust.setPostalCode(StoreCustomer.getPostalCode().getValue());
		cust.setCountry(cust.getCountry());
		cust.setSalesRepEmployeeNumber(StoreCustomer
				.getSalesRepEmployeeNumber().getValue());
		cust.setCreditLimit(StoreCustomer.getCreditLimit().getValue());

		customerDAO.saveCustomer(cust);

		return true;
	}
}
