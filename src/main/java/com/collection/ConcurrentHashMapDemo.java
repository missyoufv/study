package com.collection;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

@Slf4j
public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
//        invoke_atomicStampReference();
        invoke_concurrentHashMap();
        invoke_listIterator();
    }


    public static void invoke_concurrentHashMap() {

        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
        map.put("abc", 123);
    }


    /**
     * ABA问题解决方案 提供的工具类AtomicStampReference
     */
    public static void invoke_atomicStampReference() {


        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 0);

        new Thread(() -> {
            Integer stamp = atomicStampedReference.getStamp();
            Integer value = atomicStampedReference.getReference();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.error(" 第二次修改前stamp:{},value is :{}", stamp, value);
            System.out.println(atomicStampedReference.compareAndSet(value, 2000, stamp, stamp + 1));

        }, "t2").start();

        new Thread(() -> {

            Integer stamp = atomicStampedReference.getStamp();
            Integer value = atomicStampedReference.getReference();
            atomicStampedReference.compareAndSet(value, 200, stamp, stamp + 1);
            log.error("the thread name is :" + Thread.currentThread().getName() + " the atomic value is:" + atomicStampedReference.getReference() +
                    " and the stamp is: " + stamp);


            stamp = atomicStampedReference.getStamp();
            value = atomicStampedReference.getReference();
            log.error(" 第二次修改前stamp:{},value is :{}", stamp, value);
            boolean result = atomicStampedReference.compareAndSet(value, 100, stamp, stamp + 1);
            log.error("the thread name is :" + Thread.currentThread().getName() + " the atomic value is:" + atomicStampedReference.getReference() +
                    " and the stamp is: " + stamp + " the result is " + result);
        }, "t1").start();


    }

    /**
     * list集合能否边遍历边删除元素、
     *      可以，使用迭代器的删除方法、如果使用list的删除方法则会报错。报错原因：迭代器在调用next方法时会校验list结构修改次数
     */
    private static void invoke_listIterator() {

        List list = new ArrayList<>(Arrays.asList("a", "b", "c", "e", "f"));
        Iterator iterator = list.iterator();
//        ListIterator iterator = list.listIterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            if (next.equals("b")) {
                iterator.remove();
            } else {
                System.out.println(next);
            }
        }
    }

}
