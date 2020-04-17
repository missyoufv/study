package com.collection;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自己实现阻塞队列，解决生产消费者问题
 */

@Slf4j
public class MyBlockQueue {

    private Object lock = new Object();

    /**
     * 队列默认大小
     */
    private static final int DEFAULT_CAPACITY = 16;

    /**
     * 容器大小
     */
    private int capicaity;

    /**
     * 存放数据类型数组
     */
    private ArrayList<Object> table;

    MyBlockQueue(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException();
        }

        int cap = initialCapacity > Integer.MAX_VALUE ? Integer.MAX_VALUE : initialCapacity;
        capicaity = cap;
        table = new ArrayList(cap);
    }

    /**
     * 队列默认初始大小为16
     */
    MyBlockQueue() {
        this(DEFAULT_CAPACITY);
    }

    public synchronized void put(Object data) throws InterruptedException {

        // 如果当前容器已满，则阻塞
        while (isFull()){
            wait();
        }
        table.add(data);
        log.info(" ------元素{}入队完成------", data);
        notify();
    }


    public synchronized Object get() throws InterruptedException {
        while (isEmpty()){
            wait();
        }

        Object result = table.remove(0);
        notify();
        log.info(" ------元素{}出队完成------", result);
        return result;
    }


    private boolean isEmpty() {
        if (CollectionUtils.isEmpty(table)) {
            return true;
        }
        return false;
    }

    private boolean isFull() {
        if (table != null && table.size() == capicaity) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) throws Exception{

        AtomicInteger atomicInteger = new AtomicInteger(100);

        MyBlockQueue blockQueue = new MyBlockQueue(200);

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                while (atomicInteger.compareAndSet(atomicInteger.get(),atomicInteger.get()-1)) {
                    try {
                        if (atomicInteger.get() > 0) {
                            blockQueue.put(atomicInteger.get());
                        }else {
                            return;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "product" + i).start();
        }

        for (int i = 0; i < 1; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        blockQueue.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }, "consumer" + i).start();
        }
    }
}
