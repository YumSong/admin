package com.lames.admin.util;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSUtil {

    private static ConnectionFactory factory = new ActiveMQConnectionFactory("failover://tcp://localhost:61616");

    private static Connection connection;

    private static Session session;

    private static Queue queue;

    private static MessageProducer producer;

    static {
        try {
            connection  = factory.createConnection();
            session = connection.createSession(true, Session.CLIENT_ACKNOWLEDGE);
            queue = session.createQueue("merchantDetail");
            connection.start();
            producer = session.createProducer(queue);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void send(String str){
        try {
            Message msg = session.createTextMessage(str);
            producer.send(msg);
            session.commit();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static MessageConsumer getConsumer() throws JMSException {
        return session.createConsumer(queue);
    }

    public static Connection getConnection() throws JMSException {
        return connection;
    }

    public static Session getSession(){
        return session;
    }
    
    public static void close() {
    	try {
			connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
