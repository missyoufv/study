package com.jvm;


/**
 *  ThreadLocal
 *      线程本地变量，也有些地方叫做线程本地存储，其实意思差不多。可能很多朋友都知道ThreadLocal为变量在每个线程中都创建了一个副本，
 *      那么每个线程可以访问自己内部的副本变量。
 *
 *
 *
 *
 */
public class ThreadLocalDemo {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();


    public static void main(String[] args) {

        invoke_thread_local();

    }

    private static void invoke_thread_local() {

        new Thread(() -> {
            System.out.println(" T1 thread local variable ");
            threadLocal.set(" T1 thread local variable ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T1 thread local variable value is " +threadLocal.get());
        }, "T1").start();

        new Thread(() -> {
            System.out.println(" T2 thread local variable ");
            threadLocal.set(" T2 thread local variable ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T2 thread local variable value is " +threadLocal.get());
        }, "T2").start();

    }
}
