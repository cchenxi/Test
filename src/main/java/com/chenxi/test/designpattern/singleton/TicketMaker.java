package com.chenxi.test.designpattern.singleton;

public class TicketMaker {
    private int ticket = 1000;

    private static TicketMaker singleton = new TicketMaker();

    private TicketMaker() {

    }

    public static TicketMaker getInstance() {
        return singleton;
    }

    public synchronized int getNextTicketNumber() {
        return ticket++;
    }
}

class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + TicketMaker.getInstance().getNextTicketNumber());
        }
    }
}
