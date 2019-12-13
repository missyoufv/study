package com.distributedLock;

import redis.clients.jedis.Jedis;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

import static com.distributedLock.LockConstants.*;

/**
 * @author: duw
 * @Date: 2019/12/12 17:20
 * @Description:
 *
 *  解锁操作也确保了原子性了，那么是不是单机Redis环境的分布式锁到此就完成了?
 *  别忘了版本2-设置锁的过期时间还有一个，过期时间如何保证大于业务执行时间问题没有解决。
 *
 */
public class LockCase4 extends RedisLock {

    public LockCase4(Jedis jedis, String lockKey, String lockValue) {
        super(jedis, lockKey,lockValue);
    }

    @Override
    public void lock() {
        while (true){
            String result = jedis.set(lockKey,this.lockValue,NO_EXIST,SECONDS,60);
            if(OK.equals(result)){
                System.out.println("线程id:"+Thread.currentThread().getId() + "加锁成功!时间:"+ LocalTime.now());
                //开启定时刷新过期时间
                isOpenExpirationRenewal = true;
                scheduleExpirationRenewal();
                break;
            }
            System.out.println("线程id:"+Thread.currentThread().getId() + "获取锁失败，休眠10秒!时间:"+LocalTime.now());
            //休眠10秒
            sleepBysecond(10);
        }
    }


    @Override
    public void unlock() {
        System.out.println("线程id:"+Thread.currentThread().getId() + "解锁!时间:"+LocalTime.now());
        String checkAndDelScript = "if redis.call('get', KEYS[1]) == ARGV[1] then " +
                "return redis.call('del', KEYS[1]) " +
                "else " +
                "return 0 " +
                "end";
        jedis.eval(checkAndDelScript,1,lockKey,lockValue);
        isOpenExpirationRenewal = false;

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
    public Condition newCondition() {
        return null;
    }
}
