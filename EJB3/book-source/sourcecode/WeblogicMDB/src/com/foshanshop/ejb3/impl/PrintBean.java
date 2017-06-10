package com.foshanshop.ejb3.impl;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(mappedName="queue/foshanshop", activationConfig =
{
  @ActivationConfigProperty(propertyName="destinationType",
    propertyValue="javax.jms.Queue"),
  @ActivationConfigProperty(propertyName="acknowledgeMode", 
    propertyValue="Auto-acknowledge")
})
public class PrintBean implements MessageListener {

    public void onMessage(Message msg) {
        try {
            TextMessage tmsg = (TextMessage) msg;
            String content = tmsg.getText();
            System.out.println(content);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
