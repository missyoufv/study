package com.distributedLock;

import redis.clients.jedis.Jedis;

import static com.distributedLock.LockConstants.*;

/**
 * @author: duw
 * @Date: 2019/12/12 17:20
 * @Description:
 *
 * 问题3：
 * 抽象类RedisLock增加lockValue字段，不同的客户端，保证不同的lockValue值，再删除key的时候，获取redis的value和客户端value比较，相同删除，不相同则不删除，防止key过期而导致误删问题。
 * 引发问题，删除key的判断操作不是原子操作，多线程i++ 类似问题?
 *
 * 解决方案：
 *      删除key操作通过lua 脚本保证操作的原子性
 */
public class LockCase3 extends RedisLock {

    public LockCase3(Jedis jedis, String lockKey, String lockValue) {
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
        String checkAndDelScript = "if redis.call('get', KEYS[1]) == ARGV[1] then " +
                "return redis.call('del', KEYS[1]) " +
                "else " +
                "return 0 " +
                "end";
        jedis.eval(checkAndDelScript,1,lockKey,lockValue);

    }
}
