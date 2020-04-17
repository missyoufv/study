package com.distributedLock;

import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author: duw
 * @Date: 2019/12/12 17:10
 * @Description:  extends jdk lock
 */
public class RedisLock implements Lock {

    /**
     * redis connection object
     */
    protected Jedis jedis;

    /**
     * reids key
     */
    protected String lockKey;

    /**
     * redis value
     */
    protected String lockValue;


    protected volatile boolean isOpenExpirationRenewal = true;

    /**
     * construct method ,init the property
     * @param jedis
     * @param lockKey
     */
    public RedisLock(Jedis jedis,String lockKey,String lockValue) {
        this.jedis = jedis;
        this.lockKey = lockKey;
        this.lockValue = lockValue;
    }

    public void sleepBysecond(int second){
        try{
            Thread.sleep(second*1000);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    /**
     * 开启定时刷新
     */
    protected void scheduleExpirationRenewal(){
        Thread renewalThread = new Thread(new ExpirationRenewal());
        renewalThread.start();
    }

    @Override
    public void lock() {

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }

    /**
     * 刷新key的过期时间
     */
    private class ExpirationRenewal implements Runnable{
        @Override
        public void run() {
            while (isOpenExpirationRenewal){
                System.out.println("执行延迟失效时间中...");

                String checkAndExpireScript = "if redis.call('get', KEYS[1]) == ARGV[1] then " +
                        "return redis.call('expire',KEYS[1],ARGV[2]) " +
                        "else " +
                        "return 0 end";
                jedis.eval(checkAndExpireScript, 1, lockKey, lockValue, "30");

                //休眠10秒
                sleepBysecond(10);
            }
        }
    }




}
