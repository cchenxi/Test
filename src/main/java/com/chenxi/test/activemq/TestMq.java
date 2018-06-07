package com.chenxi.test.activemq;

public class TestMq {
    public static void main(String[] args) {
        Producer producer = new Producer();
        producer.init();
        TestMq testMq = new TestMq();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(testMq.new ProducerMq(producer)).start();
        new Thread(testMq.new ProducerMq(producer)).start();
        new Thread(testMq.new ProducerMq(producer)).start();
        new Thread(testMq.new ProducerMq(producer)).start();
        new Thread(testMq.new ProducerMq(producer)).start();
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
                    producer.sendMessage("chenxi-MQ");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
