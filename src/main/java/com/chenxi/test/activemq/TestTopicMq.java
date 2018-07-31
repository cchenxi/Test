package com.chenxi.test.activemq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestTopicMq {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestTopicMq.class);
    public static void main(String[] args) {
        Producer producer = new Producer();
        producer.init();
        TestTopicMq testTopicMq = new TestTopicMq();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            LOGGER.warn("exception", e);
        }

        new Thread(testTopicMq.new ProducerMq(producer)).start();
        new Thread(testTopicMq.new ProducerMq(producer)).start();
        new Thread(testTopicMq.new ProducerMq(producer)).start();
        new Thread(testTopicMq.new ProducerMq(producer)).start();
    }

    private class ProducerMq implements Runnable {
        Producer producer;

        public ProducerMq(Producer producer) {
            this.producer = producer;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    producer.pubicMessage("chenxi-topic-MQ");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    LOGGER.warn("exception", e);
                }
            }
        }
    }
}
