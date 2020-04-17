package com.proxy;

/**
 * JDK动态代理和cglib生成代理
 */
public class ProxyDemo {


    public static void main(String[] args) {

//        invoke_jdk_proxy();
        invoke_cglib_proxy();
    }

    /**
     * jdk代理
     */
    private static void invoke_jdk_proxy() {
        InterfaceService interfaceServiceProxy = (InterfaceService) new JDKDynamicProxy(new InterfaceServiceImpl()).getProxyInstance();
        interfaceServiceProxy.sayHello("china");

    }

    private static void invoke_cglib_proxy() {
        InterfaceServiceImpl interfaceServiceProxy = (InterfaceServiceImpl) new CglibDynamicProxy(new InterfaceServiceImpl()).getProxyInstance();
        interfaceServiceProxy.sayHello("cglib");
    }

}
