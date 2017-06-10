package com.foshanshop.ejb3.impl;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.TextMessage;

import com.foshanshop.ejb3.QSender;

/**
 * ����Queue��Ϣ
 * @author lihuoming
 *
 */
@Stateless(mappedName="QSenderBean")
@Remote (QSender.class)
public class QSenderBean implements QSender {
    @Resource(mappedName="javax.jms.QueueConnectionFactory") private QueueConnectionFactory factory;
    @Resource(mappedName="queue/foshanshop") private Queue destination;
    
	public void send() {
        QueueConnection conn = null;
        QueueSession session = null;
        try {            
            conn = factory.createQueueConnection();
            session = conn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(destination);            
            //�����ı�
            TextMessage msg = session.createTextMessage("��ɽ�����ã������ҵĵ�һ����Ϣ����Bean");
            producer.send(msg);
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try {
                session.close ();
                conn.close();
            } catch (JMSException e) {
            	 e.printStackTrace();
            }
        }
	}

}
