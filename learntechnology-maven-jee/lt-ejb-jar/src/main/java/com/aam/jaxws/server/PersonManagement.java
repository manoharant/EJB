package com.aam.jaxws.server;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService(name = "PersonManagementService")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL)
public interface PersonManagement {

	public PersonOut findPersonByCIN(@WebParam(name = "CIN") String CIN)
			throws PersonException;

}
