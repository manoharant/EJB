package com.foshanshop.ejb3.app;

import java.util.Properties;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
/**
 * 发送Topic消息
 * @author lihuoming
 *
 */
public class TopicSender {

    public static void main(String[] args) {
        TopicConnection conn = null;
        TopicSession session = null;
        try {
            Properties props = new Properties();
			props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
			props.setProperty(Context.PROVIDER_URL, "t3://localhost:7001");
            InitialContext ctx = new InitialContext(props);
            
            TopicConnectionFactory factory = (TopicConnectionFactory) ctx.lookup(TopicConnectionFactory.class.getName());
            conn = factory.createTopicConnection();
            session = conn.createTopicSession(false, TopicSession.AUTO_ACKNOWLEDGE);
            Destination destination = (Topic) ctx.lookup("topic/chatTopic");
            MessageProducer producer = session.createProducer(destination);
            //发送文本
            TextMessage msg = session.createTextMessage("您好，这是我的第一个消息驱动Bean");
            producer.send(msg);
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
