package com.foshanshop.ejb3.impl;

import com.foshanshop.ejb3.Injection;
import com.foshanshop.ejb3.LocalHello;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote (Injection.class)
public class InjectionBean implements Injection { 
    @EJB (beanName="HelloBean") LocalHello helloworld;
    public String SayHello() {  
        return helloworld.SayHello("HelloBean");
    }
}
