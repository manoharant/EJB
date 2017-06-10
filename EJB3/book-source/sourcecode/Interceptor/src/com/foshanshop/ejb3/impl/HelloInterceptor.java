package com.foshanshop.ejb3.impl;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class HelloInterceptor {

    @AroundInvoke
    public Object log(InvocationContext ctx) throws Exception {
        System.out.println("*** HelloInterceptor intercepting");
        long start = System.currentTimeMillis();
        try{
            if (ctx.getMethod().getName().equals("SayHello")){
                System.out.println("*** SayHello method entered! *** " );
            }            
            if (ctx.getMethod().getName().equals("Myname")){
                System.out.println("*** Myname entered! *** " );
            }            
            return ctx.proceed();
        }catch (Exception e) {
            throw e;
            
        }finally {
            long time = System.currentTimeMillis() - start;    
            System.out.println("total time taken:"+ time + "ms");
        }
    }
}
