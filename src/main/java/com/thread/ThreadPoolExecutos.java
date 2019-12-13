package com.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: duw
 * @Date: 2019/12/12 17:31
 * @Description: 线程池工具类
 */
public class ThreadPoolExecutos {

    private static final Integer corePoolSize = 4;

    private static final Integer maxPoolSize =  200;

    private static final long maxIdl = 60;

    private static ThreadPoolExecutor pool = new ThreadPoolExecutor(corePoolSize,maxPoolSize,maxIdl, TimeUnit.SECONDS,new ArrayBlockingQueue<>(1000));

    private ThreadPoolExecutos() {
    }

    public static void handle(Runnable task){
        pool.submit(task);
    }
}
