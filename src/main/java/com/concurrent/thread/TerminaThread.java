package com.concurrent.thread;

/**
 * @author: duw
 * @Date: 2019/12/3 15:48
 * @Description: 线程终止几种方式
 *  1、正常运行完
 *  2、使用退出标志退出线程
 *  3、使用 interrupt()方法来中断线程有两种情况
 *  4、stop 方法终止线程 方法终止线程（线程不安全）
 */
public class TerminaThread {

    private volatile boolean exit = false;

    public static void main(String[] args) throws Exception {

        TerminaThread t = new TerminaThread();
//        t.quitFlag();
//        Thread.sleep(30);
//        System.out.println("main thread is running");
//        t.exit = true;

        Thread chileThread = t.stopThread();
        chileThread.start();
        System.out.println("child thread is running");
        System.out.println("begin stop child thread");
        Thread.sleep(30);
        chileThread.stop();
        System.out.println("main thread running over");
    }

    public void quitFlag(){

        new Thread(()->{
            System.out.println("enter thread");
            while (!exit){
                System.out.println(String.format("the current time is :%s",System.currentTimeMillis()));
            }
            System.out.println("exist thread");
        }).start();
    }

    public Thread stopThread(){
        return new Thread(()->{
            while (true){
                System.out.println(String.format("the current name is :%s",Thread.currentThread().getName()));
            }
        });
    }

}
