package com.foshanshop.struts;

import com.foshanshop.ejb3.HelloWorld;
import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport{
	private static final long serialVersionUID = 6798976589116258756L;
	private HelloWorld hello;
	private String outMessage;
	public String getOutMessage() {
		return outMessage;
	}
	public void setOutMessage(String outMessage) {
		this.outMessage = outMessage;
	}
	public void setHello(HelloWorld hello) {
		this.hello = hello;
	}
	@Override
	public String execute() throws Exception {
		setOutMessage(hello.SayHello("Struts2+Spring+EJB3.0"));
		return SUCCESS;//该常量值为:"success"
	}
}
