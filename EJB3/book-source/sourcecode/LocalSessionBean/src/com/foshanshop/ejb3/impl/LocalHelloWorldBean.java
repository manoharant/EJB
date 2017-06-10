package com.foshanshop.ejb3.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.foshanshop.ejb3.LocalHelloWorld;

@Stateless
@Local ({LocalHelloWorld.class})
public class LocalHelloWorldBean implements LocalHelloWorld {

    public String SayHello(String name) {
        return name +"说：你好!世界,这是一个只具有Local接口的无状态Bean";
    }

}
