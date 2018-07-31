package com.chenxi.test.activemq;

public class TestQueueConsumer {
    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        consumer.init();

        TestQueueConsumer testQueueConsumer = new TestQueueConsumer();
        new Thread(testQueueConsumer.new ConsumerMq(consumer)).start();
        new Thread(testQueueConsumer.new ConsumerMq(consumer)).start();
        new Thread(testQueueConsumer.new ConsumerMq(consumer)).start();
        new Thread(testQueueConsumer.new ConsumerMq(consumer)).start();
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
                    consumer.getMessage("chenxi-MQ");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
