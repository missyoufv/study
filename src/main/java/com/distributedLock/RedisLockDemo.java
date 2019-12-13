package com.distributedLock;

import com.thread.ThreadPoolExecutos;
import com.utils.JedisUtil;

/**
 * @author: duw
 * @Date: 2019/12/12 17:29
 * @Description:
 */
public class RedisLockDemo {


    public static void main(String[] args) throws Exception{

//        lockCase1();
//        lockCase2();
//        lockCase3();
    }


    public static void lockCase1(){

        ThreadPoolExecutos.handle(() -> {
            System.out.println("zsan create the thread ,and begin to get the lock");
            JedisUtil jedisUtil = new JedisUtil();
            LockCase1 case1 = new LockCase1(jedisUtil.getJedis(),"com.duw.test.distribute.lock");
            case1.lock();
            System.out.println("zsan i get the lock ");
            case1.sleepBysecond(30);
        });

        ThreadPoolExecutos.handle(() -> {
            System.out.println("lsi create the thread ,and begin to get the lock");
            JedisUtil jedisUtil = new JedisUtil();
            LockCase1 case1 = new LockCase1(jedisUtil.getJedis(),"com.duw.test.distribute.lock");
            case1.lock();
            System.out.println("lsi i get the lock ");
            case1.sleepBysecond(30);
        });

    }


    public static void lockCase2() throws Exception{
        ThreadPoolExecutos.handle(() -> {
            System.out.println("wwu create the thread ,and begin to get the lock");
            JedisUtil jedisUtil = new JedisUtil();
            LockCase2 case2 = new LockCase2(jedisUtil.getJedis(),"com.duw.test.distribute.lock","dw-1");
            case2.lock();
            System.out.println("wwu i get the lock ");
            case2.sleepBysecond(60);
            System.out.println("wwu i wake up ,i will delete the key");
            case2.unlock();
            System.out.println("wwu i over, temp begin");
            LockCase2 temp = new LockCase2(jedisUtil.getJedis(),"com.duw.test.distribute.lock","dw-3");
            temp.lock();
            System.out.println("temp get lock,and over");
        });

        Thread.sleep(5);
        ThreadPoolExecutos.handle(() -> {
            System.out.println("zliu create the thread ,and begin to get the lock");
            JedisUtil jedisUtil = new JedisUtil();
            LockCase2 case2 = new LockCase2(jedisUtil.getJedis(),"com.duw.test.distribute.lock","dw-2");
            case2.lock();
            System.out.println("zliu i get the lock ");
            case2.sleepBysecond(120);
            System.out.println("zliu i wake up");
        });
    }


    public static void lockCase3() throws Exception{
        ThreadPoolExecutos.handle(() -> {
            System.out.println("wwu create the thread ,and begin to get the lock");
            JedisUtil jedisUtil = new JedisUtil();
            LockCase3 case3 = new LockCase3(jedisUtil.getJedis(),"com.duw.test.distribute.lock","dw-1");
            case3.lock();
            System.out.println("wwu i get the lock ");
            case3.sleepBysecond(60);
            System.out.println("wwu i wake up ,i will delete the key");
            case3.unlock();
            System.out.println("wwu i over, temp begin");
            LockCase3 temp = new LockCase3(jedisUtil.getJedis(),"com.duw.test.distribute.lock","dw-3");
            temp.lock();
            System.out.println("temp get lock,and over");
        });

        Thread.sleep(5);
        ThreadPoolExecutos.handle(() -> {
            System.out.println("zliu create the thread ,and begin to get the lock");
            JedisUtil jedisUtil = new JedisUtil();
            LockCase3 case3 = new LockCase3(jedisUtil.getJedis(),"com.duw.test.distribute.lock","dw-2");
            case3.lock();
            System.out.println("zliu i get the lock ");
            case3.sleepBysecond(120);
            System.out.println("zliu i wake up");
        });
    }
}
