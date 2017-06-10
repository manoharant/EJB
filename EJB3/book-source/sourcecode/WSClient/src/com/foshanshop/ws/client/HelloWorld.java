
package com.foshanshop.ws.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.2-b05-RC1
 * Generated source version: 2.1
 * 
 */
@WebService(name = "HelloWorld", targetNamespace = "http://ws.foshanshop.com")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HelloWorld {


    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "SayHello")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "SayHello", targetNamespace = "http://ws.foshanshop.com", className = "com.foshanshop.ws.client.SayHello")
    @ResponseWrapper(localName = "SayHelloResponse", targetNamespace = "http://ws.foshanshop.com", className = "com.foshanshop.ws.client.SayHelloResponse")
    public String sayHello(
        @WebParam(name = "name", targetNamespace = "")
        String name);

}