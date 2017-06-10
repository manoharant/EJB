package com.foshanshop.ws.impl;
import com.foshanshop.ws.HelloWorld;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Use;

@Stateless
@Remote (HelloWorld.class)
@WebService(targetNamespace="http://ws.foshanshop.com",
		name = "HelloWorld",
		serviceName = "HelloWorldService")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, 
		use=Use.LITERAL,
		parameterStyle=ParameterStyle.WRAPPED)
public class HelloWorldBean implements HelloWorld {
	@WebMethod(operationName="SayHello", action="")
	@WebResult(name="return")
    public String SayHello(@WebParam(name="name") String name) {
        return name +"说：你好!世界,这是我的第一个web service哦.";
    }
}
