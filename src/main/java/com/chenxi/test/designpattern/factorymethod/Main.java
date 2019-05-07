package com.chenxi.test.designpattern.factorymethod;

import com.chenxi.test.designpattern.factorymethod.framework.Factory;
import com.chenxi.test.designpattern.factorymethod.framework.Product;
import com.chenxi.test.designpattern.factorymethod.idcard.IDCard;
import com.chenxi.test.designpattern.factorymethod.idcard.IDCardFactory;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("a");
        Product card2 = factory.create("b");

        card1.use();
        card2.use();
    }
}
