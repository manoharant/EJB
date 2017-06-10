package com.foshanshop.ejb3.impl;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.foshanshop.ejb3.LocalHello;
import com.foshanshop.ejb3.RemoteHello;

@Stateless
@Remote (RemoteHello.class)
@Local(LocalHello.class)
public class HelloBean implements RemoteHello, LocalHello {

	public String SayHello(String name) {
		return name+" Mano";
	}
}
