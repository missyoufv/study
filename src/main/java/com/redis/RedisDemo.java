package com.redis;

/**
 * reids 怎么解决并发竞争的 redis 本身是线程安全的，并发竞争主要跟业务处理逻辑有关解决方案：事务的乐观锁、原子操作incryby 、同步处理业务代码等
 *
 * Redis支持几种数据类型以及存储结构是什么？
 *  五种数据类型：String（字符串），Hash（哈希），List（列表），Set（集合）及zset(sortedset：有序集合)
 *  存储结构：
 *
 */
public class RedisDemo {

    public static void main(String[] args) {

    }
}
