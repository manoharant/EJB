package com.foshanshop.ejb3.impl;

import com.foshanshop.ejb3.LifeCycle;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Init;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
@Remote (LifeCycle.class)
public class LifeCycleBean implements LifeCycle {

    public String Say() {
        try {
            Thread.sleep(1000*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "这是会话Bean生命周期应用例子";
    }

    @Init
    public void initialize () {
      System.out.println("@Init事件触发");
    }   
    
    @PostConstruct
    public void Construct () {
      System.out.println("@PostConstruct事件触发");
    }

    @PreDestroy
    public void exit () {
      System.out.println("@PreDestroy事件触发");
    }

    @PrePassivate
    public void serialize () {
      System.out.println("@PrePassivate事件触发");
    }

    @PostActivate
    public void activate () {
      System.out.println("@PostActivate事件触发");
    }

    @Remove
    public void stopSession () {
      System.out.println("@Remove事件触发"); 
      //调用该方法以通知容器，移除该bean实例、终止会话。方法体可以是空的。
    }
}
