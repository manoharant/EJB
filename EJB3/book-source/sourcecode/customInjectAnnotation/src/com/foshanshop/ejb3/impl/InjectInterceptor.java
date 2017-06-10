package com.foshanshop.ejb3.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.annotation.PostConstruct;
import javax.ejb.EJBException;
import javax.interceptor.InvocationContext;

import com.foshanshop.ejb3.Person;
import com.foshanshop.ejb3.PersonInject;

public class InjectInterceptor {
	   @PostConstruct
	   public void jndiInject(InvocationContext invocation) {
	      Object target = invocation.getTarget( );
	      Field[] fields = target.getClass().getDeclaredFields( );
	      Method[] methods = target.getClass().getDeclaredMethods( );

	      try {
	         for (Method method : methods) {
	        	PersonInject inject = method.getAnnotation(PersonInject.class);
	            if (inject != null) {
	               method.setAccessible(true);
	               method.invoke(target, new Person(inject.name(), inject.age()));
	            }
	         }
	         for (Field field : fields) {
	        	PersonInject inject = field.getAnnotation(PersonInject.class);
	            if (inject != null) {
	               field.setAccessible(true);
	               field.set(target, new Person(inject.name(), inject.age()));
	            }
	         }
	         invocation.proceed( );
	      } catch (Exception ex) {
	         throw new EJBException("÷¥––@PersonInject ß∞‹", ex);
	      }
	   }
}
