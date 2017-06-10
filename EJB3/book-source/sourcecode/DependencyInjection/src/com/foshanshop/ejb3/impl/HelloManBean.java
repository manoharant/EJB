package com.foshanshop.ejb3.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.foshanshop.ejb3.LocalHello;

@Stateless
@Local(LocalHello.class)
public class HelloManBean implements LocalHello {

	public String SayHello(String name) {
		return name+"HelloManBean";
	}
}
