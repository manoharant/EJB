package com.foshanshop.ejb3.impl;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.StreamMessage;
import javax.jms.TextMessage;

import com.foshanshop.ejb3.QSender;
import com.foshanshop.ejb3.bean.Man;

/**
 * ����Queue��Ϣ
 * @author lihuoming
 *
 */
@Stateless
@Remote (QSender.class)
public class QSenderBean implements QSender {
    @Resource(mappedName="ConnectionFactory") private QueueConnectionFactory factory;
    @Resource(mappedName="queue/foshanshop") private Queue destination;

	public void send() {
        QueueConnection conn = null;
        QueueSession session = null;
        try {
            conn = factory.createQueueConnection();
            session = conn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(destination);

            //�����ı�
            TextMessage msg = session.createTextMessage("Test Message MDB Test");
            producer.send(msg);

            //����Ojbect(�������ʵ�����л�,������ų����)
            producer.send(session.createObjectMessage(new Man("Object Message", "Parameter2")));

            //����MapMessage
            MapMessage mapmsg = session.createMapMessage();
            mapmsg.setObject("no1", "Map Message Test");
            producer.send(mapmsg);

            //����BytesMessage
            BytesMessage bmsg = session.createBytesMessage();
            bmsg.writeBytes("Byte Message Test".getBytes());
            producer.send(bmsg);

            //����StreamMessage
            StreamMessage smsg = session.createStreamMessage();
            smsg.writeString("Stream message Test,http://www.babasport.com");
            producer.send(smsg);
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
