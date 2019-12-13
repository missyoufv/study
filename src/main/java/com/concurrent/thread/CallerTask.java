package com.concurrent.thread;

import java.util.concurrent.*;

public class CallerTask implements Callable<String> {

    public static final ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 5, 60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10));
    @Override
    public String call() throws Exception {
        System.out.println("i am working");
        return "hello";
    }


    public static void main(String[] args) {
        //创建异步任务
        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
        //启动线程
        pool.submit(futureTask);

        CompletableFuture<String> completableFuture = new CompletableFuture<String>();
        try{
            if(futureTask.isDone()){
                String result = futureTask.get();
                System.out.println(result);
            }else {
                System.out.println("主线程继续运行，没有任何影响");
            }
            System.out.println("继续处理事务");
            System.out.println(29 | 0);
            System.out.println(1<<1);
            System.out.println(2<<1);
            System.out.println(3<<1);
            System.out.println(3 & -3);
            System.out.println(2 & -2);
            System.out.println(3 | -3);
            System.out.println(2 & -3);
            System.out.println(16 & 5);
            System.out.println(16 & 7);
            System.out.println(8 & 3);
            System.out.println(2 & 3);
            System.out.println(5 & -4);
            System.out.println(4 & -5);
            System.out.println("-----------------");
            System.out.println(-5 & ~4);
            System.out.println(-8 & ~7);
            System.out.println("规律如下---- （负的2左移n位 & 2左移n为-1 结果为0，前者逐渐递增，结果逐渐加1");
            System.out.println(-8&7);
            System.out.println(-7&7);
            System.out.println(-6&7);
            System.out.println(-5&7);
            System.out.println(-6&15);
            boolean result = true||true&&false;
            System.out.println("优先级测试:"+ result);
            String test = "23";
            String [] temp = test.split("_2",2);
            System.out.println(temp[0]+":"+temp[1]);
            if(true){
                System.out.println("studyApi return ");
                return;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            System.out.println("clone thread pool");
            pool.shutdown();
        }
    }
}
