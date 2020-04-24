package com.proxy;

/**
 * JDK动态代理和cglib生成代理
 *  JDK动态代理只能针对实现了接口的类生成代理。
 *  CGLIB（版CODE GENERLIZE LIBRARY）代理是针对类实现代理，主要是对指定的类生成一个子类，覆盖其中的所有方法，所以该类或方法不能声明称final的。
 */
public class ProxyDemo {


    public static void main(String[] args) {

        invoke_jdk_proxy();
        invoke_cglib_proxy();
    }

    /**
     * jdk代理
     */
    private static void invoke_jdk_proxy() {
        InterfaceService interfaceServiceProxy = (InterfaceService) new JDKDynamicProxy(new InterfaceServiceImpl()).getProxyInstance();
        interfaceServiceProxy.sayHello("china");
        System.out.println(interfaceServiceProxy);

    }

    private static void invoke_cglib_proxy() {
        InterfaceServiceImpl interfaceServiceProxy = (InterfaceServiceImpl) new CglibDynamicProxy(new InterfaceServiceImpl()).getProxyInstance();
        interfaceServiceProxy.sayHello("cglib");
        System.out.println(interfaceServiceProxy);
    }

}
