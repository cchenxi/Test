package com.chenxi.test.designpattern.factorymethod.idcard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.chenxi.test.designpattern.factorymethod.framework.Factory;
import com.chenxi.test.designpattern.factorymethod.framework.Product;

public class IDCardFactory extends Factory {
    private Map<Integer, String> database = new HashMap<>();
    private int serival = 100;

//    private List<String> owners = new ArrayList<>();

    @Override
    protected synchronized Product createProduct(String owner) {
        return new IDCard(owner, serival++);
    }

    @Override
    protected void registerProduct(Product product) {
        IDCard card = (IDCard)product;
        database.put(card.getSerial(), card.getOwner());
//        owners.add(((IDCard)product).getOwner());
    }

//    public List<String> getOwners() {
//        return owners;
//    }

    public Map<Integer, String> getDatabase() {
        return database;
    }
}
