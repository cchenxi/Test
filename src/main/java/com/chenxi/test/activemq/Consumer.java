package com.chenxi.test.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Consumer {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKEN_URL = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    AtomicInteger count = new AtomicInteger(0);

    ConnectionFactory connectionFactory;

    Connection connection;

    Session session;

    ThreadLocal<MessageConsumer> threadLocal = new ThreadLocal<>();

    public void init() {
        try {
            //创建一个链接工厂
            connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEN_URL);
            //从工厂中创建一个链接
            connection = connectionFactory.createConnection();
            //开启链接
            connection.start();
            //创建一个事务（通过参数可以设置事务的级别）
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void subscribeMessage(String topicName) {
        try {
            Destination destination = session.createTopic(topicName);
            MessageConsumer messageConsumer = null;
            if (threadLocal.get() != null) {
                messageConsumer = threadLocal.get();
            } else {
                messageConsumer = session.createConsumer(destination);
                threadLocal.set(messageConsumer);

                while (true) {
                    Thread.sleep(1000);
                    TextMessage message = (TextMessage) messageConsumer.receive();

                    if (message != null) {
                        message.acknowledge();
                        String messageStr = Thread.currentThread().getName() + "consumer:我是消费者，正在消费Topic消息：" + message.getText() + "---->" + count.getAndIncrement();
                        System.out.println(messageStr);
                    } else {
                        break;
                    }
                }
            }

        } catch (JMSException | InterruptedException e) {
            LOGGER.warn("exception", e);
        }
    }

    public void getMessage(String disname) {
        try {
            Queue queue = session.createQueue(disname);
            MessageConsumer messageConsumer = null;
            if (threadLocal.get() != null) {
                messageConsumer = threadLocal.get();
            } else {
                messageConsumer = session.createConsumer(queue);
                threadLocal.set(messageConsumer);
            }

            while (true) {
                Thread.sleep(1000);
                TextMessage message = (TextMessage) messageConsumer.receive();

                if (message != null) {
                    message.acknowledge();
                    String messageStr = Thread.currentThread().getName() + "consumer:我是消费者，正在消费消息：" + message.getText() + "---->" + count.getAndIncrement();
                    System.out.println(messageStr);
                } else {
                    break;
                }
            }
        } catch (JMSException | InterruptedException e) {
            LOGGER.warn("exception", e);
        }
    }
}
