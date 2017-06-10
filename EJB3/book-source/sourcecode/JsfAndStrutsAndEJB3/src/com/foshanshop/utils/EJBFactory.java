package com.foshanshop.utils;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EJBFactory {
	
    public static Object lookup(String ejbrefname) {
    	try {
			InitialContext ctx = new InitialContext();
			return ctx.lookup("java:comp/env/"+ ejbrefname);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return null;
    }
}
