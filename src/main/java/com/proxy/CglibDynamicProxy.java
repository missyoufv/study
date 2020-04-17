package com.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibDynamicProxy implements MethodInterceptor {

    /**
     * 被代理对象
     */
    private Object target;

    /**
     * 构造器
     * @param object
     */
    CglibDynamicProxy(Object object) {
        target = object;
    }

    /**
     * 获取代理对象实例
     * @return
     */
    public Object getProxyInstance() {
        /**
         * 工具类
         */
        Enhancer enhancer = new Enhancer();
        /**
         * 设置父类
         */
        enhancer.setSuperclass(target.getClass());
        /**
         * 设置回调
         */
        enhancer.setCallback(this);
        /**
         * 创建子类代理对象并返回
         */
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("Do something before" );
        Object result = method.invoke(target, objects);
        System.out.println("Do something after");
        return result;
    }
}
