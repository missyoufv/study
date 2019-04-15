package com.concurrent.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 自定义线程池测试
 */
public class ThreadPoolExecutorDemo {

    public static void main(String[] args) throws Exception{
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1,5,0, TimeUnit.SECONDS,new LinkedBlockingQueue<>(10));
        try {

            for (int i = 1; i <= 2; i++) {
                pool.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName());
                        try {
                            Thread.sleep(6000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });

                System.out.println("创建第" + i + "个线程后, 线程池情况:" + pool.toString());
            }
//            Executors
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            pool.shutdown();
        }

    }
}
