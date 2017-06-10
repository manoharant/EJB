package com.aam.jaxws.server.customer;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import com.aam.jaxws.server.AddCustomerRequestCustomerDetail;
import com.aam.jaxws.server.CustomerDetail;

@WebService(name = "CustomerManagementService")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL)
public interface CustomerManagement {
	public CustomerDetail findCustomerByID(@WebParam(name = "customerID") String customerID);

	public List<CustomerDetail> getCustomers();

	public List<CustomerDetail> findCustomerByName(
			@WebParam(name = "customerName") String customerName);

	public boolean addCustomer(@WebParam(name = "StoreCustomer") AddCustomerRequestCustomerDetail StoreCustomer);
}
