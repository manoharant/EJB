package com.foshanshop.spring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * �Զ���ע�ͣ�����ע����Spring�����Bean
 * @author lihuoming
 *
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SpringBean {
	/** Bean��id **/
	String beanid() default "";
}
