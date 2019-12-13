package com.distributedLock;

import redis.clients.jedis.Jedis;

import static com.distributedLock.LockConstants.*;

/**
 * @author: duw
 * @Date: 2019/12/12 17:20
 * @Description:
 * 问题1  通过 SET lockKey value NX
 *        存在问题：获取到锁的客户端异常中断，导致锁一致不能释放，其他客户端一致拿不到锁
 */
public class LockCase1 extends RedisLock {

    public LockCase1(Jedis jedis, String lockKey) {
        super(jedis, lockKey,null);
    }

    @Override
    public void lock() {
        while (true){
            String result = jedis.set(lockKey,String.valueOf(System.currentTimeMillis()),NO_EXIST);
            if(OK.equals(result)){
                System.out.println("lock success");
                break;
            }
        }
    }

    @Override
    public void unlock() {
        jedis.del(lockKey);
    }
}
