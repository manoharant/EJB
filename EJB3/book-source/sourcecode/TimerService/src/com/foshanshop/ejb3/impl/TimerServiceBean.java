package com.foshanshop.ejb3.impl;

import java.util.Date;

import com.foshanshop.ejb3.TimerServiceDAO;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

@Stateless
@Remote (TimerServiceDAO.class)
public class TimerServiceBean implements TimerServiceDAO {
    private static int count = 0;
    @Resource private TimerService timerService;

    public void scheduleTimer(long milliseconds){
        if(count ==0 ){
        	count = 1;
            timerService.createTimer(new Date(new Date().getTime() + milliseconds),
            		milliseconds, "Timer Test");
        }
    }

    @Timeout
    public void timeoutHandler(Timer timer){
       System.out.println("-------------- "+ count +"--------------");
       System.out.println("Timer Info: " + timer.getInfo());

       if (count>=5){
           timer.cancel();
           count = 0;
       }else{
    	   count++;
       }
    }
}
