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
	//����㲻����@SpringBean.beanid()���ԣ�Ĭ��ʹ�ñ�ע������������ΪBean��ID����Ҳ����ָ��Bean��ID,�磺@SpringBean(beanid="com.foshanshop.ejb3.HelloWorld")
	
	@SpringBean //ע��Spring�����HelloWorld Bean
	private HelloWorld helloWorld;
	private HelloWorld hello;
	
	@SpringBean //��ע��Ҳ��������setter������
	public void setHello(HelloWorld hello) {
		this.hello = hello;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
	            HttpServletRequest request, 
	            HttpServletResponse response) throws Exception {
		
		StringBuffer out = new StringBuffer();
		out.append(helloWorld.SayHello("Struts+Spring+EJB3.0"));
		out.append(hello.SayHello("<br>�й���"));
		request.setAttribute("ourmessage", out.toString());		
	    return mapping.findForward("print");
	}
}
