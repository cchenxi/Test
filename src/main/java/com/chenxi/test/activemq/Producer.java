package com.chenxi.test.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKEN_URL = ActiveMQConnection.DEFAULT_BROKER_URL;

    AtomicInteger count = new AtomicInteger(0);

    ConnectionFactory connectionFactory;

    Connection connection;

    Session session;

    ThreadLocal<MessageProducer> threadLocal = new ThreadLocal<>();

    public void init() {
        try {
            //创建一个链接工厂
            connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEN_URL);
            //从工厂中创建一个链接
            connection = connectionFactory.createConnection();
            //开启链接
            connection.start();
            //创建一个事务（通过参数可以设置事务的级别）
            session = connection.createSession(true, Session.SESSION_TRANSACTED);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String disname) {
        try {
            Queue queue = session.createQueue(disname);
            MessageProducer messageProducer = null;
            if (threadLocal.get() != null) {
                messageProducer = threadLocal.get();
            } else {
                messageProducer = session.createProducer(queue);
                threadLocal.set(messageProducer);
            }

            while (true) {
                Thread.sleep(1000);
                int num = count.getAndIncrement();
                String messageStr = Thread.currentThread().getName() + "producer:我是生产者，正在生产消息！count:" + num;
                TextMessage message = session.createTextMessage(messageStr);
                System.out.println(messageStr);
                messageProducer.send(message);
                session.commit();
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
