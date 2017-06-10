package com.foshanshop.conf;
import java.util.Properties;
import javax.naming.InitialContext;

public class Constants {
    private static InitialContext ctx = null;
    
    public static InitialContext getInitialContext() {
        if (ctx!=null){
            return ctx;
        }else{            
            try {
                Properties props = new Properties();
                props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("jndi.properties"));
                ctx = new InitialContext(props);
            } catch (Exception e) {
                ctx = null;
            }            
            return ctx;
        }     
    }
}
