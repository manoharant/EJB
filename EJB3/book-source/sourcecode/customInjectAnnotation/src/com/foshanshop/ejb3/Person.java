package com.foshanshop.ejb3;

import java.io.Serializable;

public class Person implements Serializable{

	private static final long serialVersionUID = 7448342896203789075L;
	private String name;//ĞÕÃû
    private Integer age;//ÄêÁä

	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.getClass().getName()+ "[name=" + this.name + ", age="+ this.age+ "]";
	}
}
