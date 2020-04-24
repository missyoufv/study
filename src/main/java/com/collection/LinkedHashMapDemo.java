package com.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * 有序map集合：
 *      控制有序参数：accessOrder
 *          值: false
 *                  基于插入顺序(先插入，迭代的时候先获取）
 *              true：
 *                  基于访问顺序 （最先获取使用最近使用最少的元素）
 *
 *
 *      实现原理：
 *          put 方法调用的父类的方法，但是重写了 new Node 方法，并在此方法中维护了双向链表
 *          remove 方法调用的父类的方法，但是重写了afterNodeRemoval 方法，在此方法中维护了双向链表
 *
 *      访问顺序的维护过程：
 *          LinkedHashMap 默认情况下， 是按插入顺序维护链表。不过我们可以在初始化 LinkedHashMap，指定 accessOrder 参数为 true，即可让它按访问顺序维护链表。
 *          访问顺序的原理上并不复杂，当我们调用get/getOrDefault/replace等方法时，只需要将这些方法访问的节点移动到链表的尾部即可。相应的源码如下
 *
 * 应用场景：
 *      实现基于LRU的缓存
 *
 */
public class LinkedHashMapDemo {

    public static void main(String[] args) {

        invoke_linkHashMap();

    }

    /**
     * linkedHashMap 有序验证
     */
    private static void invoke_linkHashMap() {

        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap(16, 0.75f, true);
        linkedHashMap.put("a", "day");
        linkedHashMap.put("b", "day1");
        linkedHashMap.put("c", "day2");
//        linkedHashMap.put("c", "good");
//        linkedHashMap.get("a");
        linkedHashMap.forEach((key,value)-> System.out.println(key+" : " + value));

    }
}
