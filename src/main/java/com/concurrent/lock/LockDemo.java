package com.concurrent.lock;


import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 根据线程获取锁的抢占时机分为：公平锁和非公平锁 (ReentrantLock 提供了公平和非公平的实现)
 *  公平锁：先到先得
 *  非公平锁：先到也不一定先得
 *
 *
 *  TODO:公平锁和非公平锁怎么实现原理？
 */
public class LockDemo {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);//公平锁  false 和默认 都是非公平锁
        AtomicInteger atomicInteger = new AtomicInteger(1);
        List list;
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        System.out.println("beging LockSupport utils");
        LockSupport.unpark(Thread.currentThread());
        LockSupport.park();
        System.out.println("LockSupport end");

        int num = 1;
//        assert num == 2:"assert 测试bu通过";
        System.out.println("assert 测试");
        int i=0;
        if(i ==1){
            System.out.println(i);
        }else if((i=2)==3){
            System.out.println("studyApi 复制");
            System.out.println(i);
        }else
            System.out.println("studyApi"+i);


        ConcurrentLinkedQueue linkedQueue = new ConcurrentLinkedQueue();
        linkedQueue.add(12);
        System.out.println(linkedQueue.poll());
    }



}
