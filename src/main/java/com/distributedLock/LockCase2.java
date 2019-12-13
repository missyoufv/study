package com.distributedLock;

import redis.clients.jedis.Jedis;

import static com.distributedLock.LockConstants.*;

/**
 * @author: duw
 * @Date: 2019/12/12 17:20
 * @Description:
 * 通过 SET lockKey value NX EX 30
 *        解决问题1 获取到锁的客户端异常中断，导致锁一致不能释放，其他客户端一致拿不到锁的问题，时间到了锁自动释放
 *
 * 问题2：
 *      客户端A获取锁成功，过期时间30秒。
 *      客户端A在某个操作上阻塞了50秒。
 *      30秒时间到了，锁自动释放了。
 *      客户端B获取到了对应同一个资源的锁。
 *      客户端A从阻塞中恢复过来，释放掉了客户端B持有的锁
 *
 *      这时会有两个问题
 *
 * 过期时间如何保证大于业务执行时间?
 * 如何保证锁不会被误删除?
 *
 *      先来解决如何保证锁不会被误删除这个问题。
 *      这个问题可以通过设置value为当前客户端生成的一个随机字符串，且保证在足够长的一段时间内在所有客户端的所有获取锁的请求中都是唯一的。
 *
 */
public class LockCase2 extends RedisLock {

    public LockCase2(Jedis jedis, String lockKey,String lockValue) {
        super(jedis, lockKey,lockValue);
    }

    @Override
    public void lock() {
        while (true){
            String result = jedis.set(lockKey,this.lockValue,NO_EXIST,SECONDS,60);
            if(OK.equals(result)){
                System.out.println("lock success");
                break;
            }
        }
    }

    @Override
    public void unlock() {

        /**
         * 此处不具备原子性,可以分为三个步骤
         * 1.获取锁对应的value值
         * 2.检查是否与requestId相等
         * 3.如果相等则删除锁（解锁）
         */
        String value = jedis.get(lockKey);
        System.out.println("redis value is" + value+":,lockValue is "+this.lockValue);
        if (this.lockValue.equals(value)){
            jedis.del(lockKey);
        }
    }
}
