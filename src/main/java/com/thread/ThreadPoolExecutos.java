package com.thread;

import java.util.concurrent.*;

/**
 *   线程池的有点：
 *      线程复用
 *      控制最大并发数
 *      管理线程
 *
 *   线程池的创建方法
 *
 *      Executors的创建线程池的方法，创建出来的线程池都实现了ExecutorService接口。常用方法有以下几个：
 *
 *          newFiexedThreadPool(int Threads)：创建固定数目线程的线程池。
 *          newCachedThreadPool()：创建一个可缓存的线程池，调用execute 将重用以前构造的线程（如果线程可用）。如果没有可用的线程，则创建一个新线程并添加到池中。
 *                                 终止并从缓存中移除那些已有 60 秒钟未被使用的线程。
 *          newSingleThreadExecutor()创建一个单线程化的Executor。
 *          newScheduledThreadPool(int corePoolSize)创建一个支持定时及周期性的任务执行的线程池，多数情况下可用来替代Timer类。
 *
 *              newFiexedThreadPool 、newSingleThreadExecutor 允许的请求队列长度为Integer.MAX_VALUE，可能会堆积大量请求导致oom
 *              newCachedThreadPool、newScheduledThreadPool 允许创建的最大线程数为Integer.MAX_VALUE，可能大量创建线程，导致oom
 *
 *
 *         阿里巴巴Java开发手册中也明确指出，而且用的词是『不允许』使用Executors创建线程池。 为什么不允许使用：因为有些创建线程池使用了无界队列可能产生**OOM**
 *
 *              Java中的BlockingQueue主要有两种实现，分别是ArrayBlockingQueue 和 LinkedBlockingQueue。
 *              **ArrayBlockingQueue**是一个用数组实现的有界阻塞队列，必须设置容量。
 *              **LinkedBlockingQueue**是一个用链表实现的有界阻塞队列，容量可以选择进行设置，不设置的话，将是一个无边界的阻塞队列，最大长度为Integer.MAX_VALUE。
 *                  这里的问题就出在：不设置的话，将是一个无边界的阻塞队列，最大长度为Integer.MAX_VALUE。也就是说，如果我们不设置LinkedBlockingQueue的容量的话，其默认容量将会
 *                  是Integer.MAX_VALUE。
 *
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


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        invoke_executors_method();
        invoke_newThreadPoollExecutor();
        /**
         * 左移里一个比较特殊的情况是当左移的位数超过该数值类型的最大位数时,编译器会用左移的位数取余
         *  33%32 = 1
         */
        System.out.println(-1<<33);
        System.out.println(-1<<32);
        System.out.println(1>>32);
        System.out.println(3<<32);
    }

    /**
     * 使用自定义线程池
     */
    private static void invoke_newThreadPoollExecutor() throws ExecutionException, InterruptedException {
        Future future = pool.submit(() ->{
            System.out.println(Thread.currentThread().getName());
            return "Success";
        });
        System.out.println(future.get());

    }

    /**
     * 调用Executors 工具类 创建线程池
     */
    private static void invoke_executors_method() {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
