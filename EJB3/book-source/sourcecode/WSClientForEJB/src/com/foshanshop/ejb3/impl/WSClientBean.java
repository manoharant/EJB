package com.foshanshop.ejb3.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.xml.ws.WebServiceRef;

import com.foshanshop.ejb3.WSClient;
import com.foshanshop.ws.client.HelloWorld;
import com.foshanshop.ws.client.HelloWorldService;

@Stateless
@Remote(WSClient.class)
public class WSClientBean implements WSClient {
	@WebServiceRef(wsdlLocation="http://localhost:8080/WsHelloWorld/HelloWorldBean?wsdl")
	private HelloWorldService service;

	public String invokeWs(String name) {
		HelloWorld helloWorld = service.getHelloWorldPort();
		return helloWorld.sayHello(name);
	}
}
