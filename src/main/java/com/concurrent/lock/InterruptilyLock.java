package com.concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock 具有synchronized不具备的可中断获取锁、非阻塞获取锁 、超时获取锁
 */
public class InterruptilyLock {

    //静态变量
    static Lock lock =new ReentrantLock();
    static Lock lock_try = new ReentrantLock();
    static Lock lock_time = new ReentrantLock();

    public static void main(String[] args) throws Exception{

        System.out.println("---------------可中断and不可中断获取锁------------------");
        Thread t1 = new Thread(()->{
            //不可中断锁，在等待获取锁的过程，忽略中断
            lock.lock();
            try {
                System.out.println("线程："+Thread.currentThread().getName()+"获取到锁");
            }catch (Exception ex){
                ex.printStackTrace();
            }finally {
                lock.unlock();
            }
        },"Thread-A");

        Thread t2 = new Thread(()->{
            try {
                //可中断锁，在等待获取锁的过程中，如果有中断到来，将会停止获取锁，并抛出中断异常
                lock.lockInterruptibly();
                try{//
                    System.out.println("线程"+Thread.currentThread().getName()+"成功获取锁");
                }finally{
                    lock.unlock();
                }
            } catch (InterruptedException e) {
                System.out.println("停止获取锁，并抛出中断异常");
                e.printStackTrace();
            }
        });


        //mian线程保持着锁时，再启动A、B线程，确保中断A、B线程时，A、B线程在等待获取锁
        lock.lock();
        try{
            t1.start();
            t2.start();
            System.out.println("中断A、B线程");
            t1.interrupt();
            t2.interrupt();
        }finally{
            lock.unlock();
        }
        TimeUnit.SECONDS.sleep(3);
        System.out.println("---------------非阻塞获取锁------------------");

        Thread t3 = new Thread(()->{
            if(lock_try.tryLock()){//尝试非阻塞获取锁
                try{
                    System.out.println("线程"+Thread.currentThread().getName()+"成功获取锁");
                }finally {//释放锁
                    lock.unlock();
                }
            }else{
                System.out.println("线程"+Thread.currentThread().getName()+"获取锁失败！");
            }
        },"Thread-C");

        if(lock_try.tryLock()){//main线程成功获取锁后，启动线程A
            try{
                t3.start();
                System.out.println(Thread.currentThread().getName()+"启动线程C");
                //sleep可以保持锁，模拟main线程还要运行1秒
                TimeUnit.SECONDS.sleep(1);
            }catch (Exception ex){
                ex.printStackTrace();
            }finally {
                lock_try.unlock();
            }
        }else{
            System.out.println("程序结束！");
        }


        TimeUnit.SECONDS.sleep(3);
        System.out.println("---------------超时塞获取锁------------------");

        Thread t4 = new Thread("D"){
            @Override
            public void run() {
                try {
                    if(lock_time.tryLock(1,TimeUnit.SECONDS)){//超时等待获取锁
                        try{
                            System.out.println(getName()+"成功获取锁");
                        }finally {
                            lock_time.unlock();
                        }
                    }else{
                        System.out.println(getName()+"获取锁失败！");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        if(lock_time.tryLock()){//main线程成功获取锁后，启动线程A
            try{
                t4.start();
                System.out.println(Thread.currentThread().getName()+"启动线程A");
                //sleep可以保持锁，模拟main线程还要运行1秒
                TimeUnit.SECONDS.sleep(1);
            }finally {
                lock_time.unlock();
            }
        }else{
            System.out.println("程序结束！");
        }
    }



}
