package com.foshanshop.ejb3.impl;

import com.foshanshop.ejb3.HelloWorld;
import com.foshanshop.ejb3.HelloWorldLocal;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless(mappedName="HelloWorldBean")
@Remote (HelloWorld.class)
@Local (HelloWorldLocal.class)
public class HelloWorldBean implements HelloWorld, HelloWorldLocal {

    public String SayHello(String name) {        
        return name +"˵�����!�����ҵĵ�һ��weblogic EJB3Ŷ��NB��?";
    }

}
