package com.concurrent.lock;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class ParkDemo {

    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws Exception{


        Thread t1 = new Thread(()->{
            try{
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+" -->enter");

                lock.lock();
                LockSupport.park();
                System.out.println(Thread.currentThread().getName()+" -->run");
            }catch (Exception ex){
                ex.printStackTrace();
            }finally {
                lock.unlock();
            }

        },"t1");

        Thread t2 = new Thread(()->{
            try{
                System.out.println(Thread.currentThread().getName()+" -->enter");
                lock.lock();
                LockSupport.park();
                System.out.println(Thread.currentThread().getName()+" -->run");
            }catch (Exception ex){
                ex.printStackTrace();
            }finally {
                lock.unlock();
            }

        },"t2");

        t1.start();
        t2.start();
        System.out.println("获取线程t1与LockSupport的关联");
        Thread.sleep(500);
        LockSupport.unpark(t1);
        t2.interrupt();

    }
}
