package com.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 根据ReentrantLock 学习aqs独占式同步状态的获取与释放
 */
public class ReentrantLockDemo {

    static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) throws Exception {

        try{
            lock.lock();

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
            lock.unlock();
        }



    }

    public static void printMsg(String msg) {
        try{
            Thread.sleep(500);
            System.out.println("enter thread,thread name is :" + msg);
            lock.lock();
            System.out.println("out thread,thread name is :" + msg);
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}
