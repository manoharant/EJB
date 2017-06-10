package com.foshanshop.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.foshanshop.ejb3.HelloWorld;
import com.foshanshop.spring.SpringBean;

public class HelloWorldAction extends Action{
	//如果你不设置@SpringBean.beanid()属性，默认使用被注入对象的类名作为Bean的ID。你也可以指明Bean的ID,如：@SpringBean(beanid="com.foshanshop.ejb3.HelloWorld")
	
	@SpringBean //注入Spring管理的HelloWorld Bean
	private HelloWorld helloWorld;
	private HelloWorld hello;
	
	@SpringBean //该注释也可以用在setter方法上
	public void setHello(HelloWorld hello) {
		this.hello = hello;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
	            HttpServletRequest request, 
	            HttpServletResponse response) throws Exception {
		
		StringBuffer out = new StringBuffer();
		out.append(helloWorld.SayHello("Struts+Spring+EJB3.0"));
		out.append(hello.SayHello("<br>中国人"));
		request.setAttribute("ourmessage", out.toString());		
	    return mapping.findForward("print");
	}
}
