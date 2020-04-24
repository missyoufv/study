package com.collection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author: duw
 * @Date: 2019/9/5 20:07
 * @Description:
 */
public class HashMapDemo {

    public static void main(String[] args)throws  Exception {
        HashMap<Integer, String> map = new HashMap<>(8);
        map.put(1, "abc");
        map.put(2, "bcd");
        Class<? extends HashMap> aClass = map.getClass();
        Field entrySet = aClass.getDeclaredField("entrySet");
        entrySet.setAccessible(true);
        // 此处拿到entrySet 结果是null
        System.out.println(entrySet.get(map));
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        for (;iterator.hasNext();) {
            Map.Entry<Integer, String> next = iterator.next();
            System.out.println(next.getKey() +" : " + next.getValue());
        }
    }
}
