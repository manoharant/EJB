<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="javax.naming.*, java.text.*, javax.jms.*, com.foshanshop.conf.Constants"%>
<%
    QueueConnection cnn = null;
    QueueSender sender = null;
    QueueSession sess = null;
    Queue queue = null;

    try {
      InitialContext ctx = Constants.getInitialContext();
      QueueConnectionFactory factory = (QueueConnectionFactory) ctx.lookup("java:/ConnectionFactory");
      cnn = factory.createQueueConnection();
      sess = cnn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
	  queue = (Queue) ctx.lookup("queue/foshanshop");
    } catch (Exception e) {
		out.println(e.getMessage());
    }

    TextMessage msg = sess.createTextMessage("佛山人您好，这是我的第一个消息驱动Bean");
    sender = sess.createSender(queue);
    sender.send(msg);
    sess.close ();
	out.println("消息已经发送出去了，你可以到Tomcat控制台查看Bean的输出");
%>