package com.foshanshop.spring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 自定义注释，用于注入受Spring管理的Bean
 * @author lihuoming
 *
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SpringBean {
	/** Bean的id **/
	String beanid() default "";
}
