package com.pattern.proxy.optimization;

import com.pattern.proxy.base.Server;
import com.pattern.proxy.base.SinaServer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


/**
 * 动态代理
 */
public class Client {

    public static void main(String[] args) {

        Server sinaServer = new SinaServer();
        InvocationHandler invocationHandler = new NginxInvocationHandler(sinaServer);
        Server proxy = (Server) Proxy.newProxyInstance(Client.class.getClassLoader(), new Class[]{Server.class}, invocationHandler);

        System.out.println(proxy.getPageTitle("http://www.sina.com.cn/"));
    }
}
