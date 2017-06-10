package com.foshanshop.AppTest;

import com.foshanshop.ws.client.HelloWorld;
import com.foshanshop.ws.client.HelloWorldService;

public class TestHelloWorld {
    public static void main(String[] args) {
        try {
        	HelloWorldService service = new HelloWorldService();
        	HelloWorld helloWorld = service.getHelloWorldPort();
        	String result = helloWorld.sayHello("Manoharan");
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
