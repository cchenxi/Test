package com.chenxi.test.easycoding;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapTest {
    public static void main(String[] args) {
        House seller1 = new House("1号卖家房源");
        SellerInfo sellerInfo1 = new SellerInfo();

        House seller2 = new House("2号卖家房源");
        SellerInfo sellerInfo2 = new SellerInfo();

        Map<House, SellerInfo> weakHashMap = new WeakHashMap<>();

        weakHashMap.put(seller1, sellerInfo1);
        weakHashMap.put(seller2, sellerInfo2);

        System.out.println("weakHashMap before null, size = " + weakHashMap.size());

        seller1 = null;

        System.gc();
        System.runFinalization();

        System.out.println("weakHashMap after null, size = " + weakHashMap.size());
        System.out.println(weakHashMap);
    }
}

class SellerInfo {

}
