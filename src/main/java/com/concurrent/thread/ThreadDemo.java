package com.concurrent.thread;

public class ThreadDemo {

    public static void main(String[] args) throws Exception {

        System.out.println("----join---- method example start");
        Thread t1 = new Thread(()-> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread one run");
        });
        Thread t2 = new Thread(()-> System.out.println("thread two run"));
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("----join---- method example over");

        System.out.println("----interrupt---- method example start");
        //线程中断
        Thread t3 = new Thread(()->{
            while(!Thread.currentThread().isInterrupted()){
                System.out.println(Thread.currentThread() + ":hello");
            }
        });
        t3.start();
        System.out.println("main thread interrupt child thread");
        Thread.sleep(20);
        t3.interrupt();
        t3.join();
        System.out.println("----interrupt---- method example over");


        Thread t4 = new Thread(()->{
           for(;;){
//               System.out.println("interrupt 并不能中断立即中断线程");
           }
        });

        t4.start();
        t4.interrupt();

        System.out.println("t4线程中断标志"+t4.isInterrupted());
        System.out.println("主线程获取中断标志并重置"+Thread.interrupted());
        System.out.println("t4线程获取中断标志并重置"+t4.interrupted());
        System.out.println("t4线程中断标志"+t4.isInterrupted());
        t4.join();
        System.out.println("over over");


    }
}
