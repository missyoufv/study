package com.proxy;

public class InterfaceServiceImpl implements InterfaceService {
    @Override
    public void sayHello(String name) {
        System.out.println(" hello " + name +" are you ok");
    }
}
