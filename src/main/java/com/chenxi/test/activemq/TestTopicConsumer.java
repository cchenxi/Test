package com.chenxi.test.activemq;

public class TestTopicConsumer {
    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        consumer.init();

        TestTopicConsumer testConsumer = new TestTopicConsumer();
        new Thread(testConsumer.new ConsumerMq(consumer)).start();
        new Thread(testConsumer.new ConsumerMq(consumer)).start();
        new Thread(testConsumer.new ConsumerMq(consumer)).start();
        new Thread(testConsumer.new ConsumerMq(consumer)).start();
    }

    private class ConsumerMq implements Runnable {
        Consumer consumer;

        public ConsumerMq(Consumer consumer) {
            this.consumer = consumer;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    consumer.subscribeMessage("chenxi-topic-MQ");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
