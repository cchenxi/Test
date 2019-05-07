package com.chenxi.test.language.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import com.alibaba.fastjson.JSON;

/**
 * Created by tn-ma-l00000590 on 2018/3/2.
 */
public class PrintingContainers {
    static Collection fill(Collection<String> collection) {
        collection.add("cat");
        collection.add("cat");
        collection.add("dog");
        collection.add("dog");
        return collection;
    }

    static Map fill(Map<String, String> map) {
        map.put("cat", "Fuzzy");
        map.put("cat", "Rags");
        map.put("dog", "Bosco");
        map.put("dog", "Spot");
        return map;
    }

    static boolean fallback = false;

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(fill(new ArrayList<String>())));
        System.out.println(JSON.toJSONString(fill(new LinkedList<String>())));
        System.out.println(JSON.toJSONString(fill(new HashSet<String>())));
        System.out.println(JSON.toJSONString(fill(new TreeSet<String>())));
        System.out.println(JSON.toJSONString(fill(new LinkedHashSet<String>())));

        System.out.println(JSON.toJSONString(fill(new HashMap<String, String>())));
        System.out.println(JSON.toJSONString(fill(new TreeMap<String, String>())));
        System.out.println(JSON.toJSONString(fill(new LinkedHashMap<String, String>())));

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                fallback = true;
            }
            System.out.println(i + "-" + i%2);
            System.out.println(fallback);
        }
    }
}
