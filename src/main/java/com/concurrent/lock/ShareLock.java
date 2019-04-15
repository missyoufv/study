package com.concurrent.lock;

import java.util.concurrent.CountDownLatch;

/**
 * 根据CountDownLatch 学习aqs 共享式同步状态获取与释放
 */
public class ShareLock {
    static CountDownLatch countDownLatch = new CountDownLatch(1);
    public static void main(String[] args) throws Exception {

        try{

            Thread t1 = new Thread(new Runnable() {

                @Override
                public void run() {
                    printMsg(Thread.currentThread().getName());
                }
            },"t1");


            Thread t2 = new Thread(new Runnable() {

                @Override
                public void run() {
                    printMsg(Thread.currentThread().getName());
                }
            },"t2");


            Thread t3 = new Thread(new Runnable() {

                @Override
                public void run() {
                    printMsg(Thread.currentThread().getName());
                }
            },"t3");


            t1.start();
            t2.start();
            t3.start();
            Thread.sleep(5000);
        }finally {
            countDownLatch.countDown();
        }



    }

    public static void printMsg(String msg) {
        try{
            Thread.sleep(500);
            System.out.println("enter thread,thread name is :" + msg);
            countDownLatch.await();
            System.out.println("out thread,thread name is :" + msg);
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
        }

    }
}
