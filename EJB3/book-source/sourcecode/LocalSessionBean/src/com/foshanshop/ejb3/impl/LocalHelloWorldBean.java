package com.foshanshop.ejb3.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.foshanshop.ejb3.LocalHelloWorld;

@Stateless
@Local ({LocalHelloWorld.class})
public class LocalHelloWorldBean implements LocalHelloWorld {

    public String SayHello(String name) {
        return name +"˵�����!����,����һ��ֻ����Local�ӿڵ���״̬Bean";
    }

}
