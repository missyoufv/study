package com.concurrent.lock;

import java.io.Serializable;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class AQSLock implements Lock, Serializable {


    //内部帮助类
    private static class  Sync extends AbstractQueuedSynchronizer{
        //是否锁已经被持有
        protected  boolean isHeldExclusively(){
            return getState() == 1;
        }
        //如果state为0 则尝试获取锁
        public boolean tryAcquire(int acquires){
            assert acquires == 1;
            if(compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }
        //尝试释放锁，设置state 为0
        protected boolean tryRelease(int acquire){
            assert acquire == 1;
            if(getState() == 0){
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
        //提供条件变量接口
        Condition newCondition(){
            return new ConditionObject();
        }

    }

    //创建一个Sync来做具体的工作
    private final  Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }


    @Override
    public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(timeout));
    }

    public boolean isLocked(){
        return sync.isHeldExclusively();
    }


    final static AQSLock lock = new AQSLock();
    final static Condition full = lock.newCondition();
    final static Condition empty = lock.newCondition();
    final static Queue<String> queue = new LinkedBlockingQueue<>();
    final static int queueSize = 10;

    public static void main(String[] args) {

        //生产者 消费者模型
        new Thread(()->{
            lock.lock();
            try{
                while (queue.size() == queueSize){
                    full.await();
                }

                //添加元素到队列中
                System.out.println("product info is hello");
                queue.add("hello");
                //唤醒消费线程
                empty.signal();
            }catch (Exception ex){
                ex.printStackTrace();
            }finally {
                lock.unlock();
            }
        }).start();

        new Thread(()->{

            lock.lock();
            try{
                while (queue.size() == 0){
                    empty.await();
                }
                //消费一个元素
                String content = queue.poll();
                System.out.println("consumer info is:" +content);
                //唤醒已满队列
                full.signal();
            }catch (Exception ex){
                ex.printStackTrace();
            }finally {
                lock.unlock();
            }
        }).start();
    }
}
