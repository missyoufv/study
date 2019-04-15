package com.pattern.adapter.base;

/**
 * 适配器类
 */
public class Adapter extends Target {

    private Adaptee adaptee = new Adaptee();

    // 把request方法的调用转换成specificRequest方法的调用
    public void request() {
        adaptee.specificRequest();
    }

}
