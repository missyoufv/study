package com.pattern.iterator.base;

//抽象迭代器
interface Iterator
{
    Object first();
    Object next();
    boolean hasNext();
}
