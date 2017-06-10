package com.foshanshop.web.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding; 

@WebService(targetNamespace="http://ws.foshanshop.com",
		name = "HelloWorld",
		serviceName = "HelloWorldService")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class HelloWorldService{
	
	@WebMethod(operationName="SayHello")
    public String SayHello(@WebParam(name="name") String name) {
        return name +" welcome to WS";
    }
}
