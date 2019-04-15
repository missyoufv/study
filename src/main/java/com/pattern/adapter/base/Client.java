package com.pattern.adapter.base;


public class Client {

    public static void main(String[] args) {

        Target target=new Adapter();

        // 客户端调用target的request方法即可
        target.request();
    }

}
