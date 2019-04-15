package com.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {

    private static int i =10;
    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {

        Thread t1 = new Thread(()->{

            try{
                lock.lock();
                if(i == 5){
                    System.out.println("i am coming");
                }else {
                    System.out.println("i have job,need wait some time");
                    condition.await();
                    System.out.println("i finsh the job,i am coming baby");
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }finally {
                lock.unlock();
            }
        },"t1");

        Thread t2 = new Thread(()->{
            try{
                lock.lock();
                for (;i>0;i--){
                    System.out.println("i am finish the job num" + i);
                    if(i == 5){
                        condition.signal();
                    }
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }finally {
                lock.unlock();
            }
        },"t2");

        t1.start();
        t2.start();
    }
}
