package com.concurrent.lock;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 产生原因 hashmap不安全 hashtable性能低
 */
public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("1",2);
        System.out.println(map);
    }
}
