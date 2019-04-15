package com.pattern.proxy.base;


/**
 * 静态代理的缺点
 *
 * 静态代理的特点是静态代理的代理类是程序员创建的，在程序运行之前静态代理的.class文件已经存在了。
 *
 * 从静态代理模式的代码来看，静态代理模式确实有一个代理对象来控制实际对象的引用，并通过代理对象来使用实际对象。这种模式在代理量较小的时候还可以，
 * 但是代理量一大起来，就存在着两个比较大的缺点：
 *
 * 1、静态代理的内容，即NginxProxy的路由选择这几行代码，只能服务于Server接口而不能服务于其他接口，如果其它接口想用这几行代码，比如新增一个静态代理类。
 * 久而久之，由于静态代理的内容无法复用，必然造成静态代理类的不断庞大
 *
 * 2、Server接口里面如果新增了一个方法，比如getPageData(String url)方法，实际对象实现了这个方法，代理对象也必须新增方法getPageData(String url)，
 * 去给getPageData(String url)增加代理内容（假如需要的话）
 */
public class Client {

    public static void main(String[] args) {
        Server sinaServer = new SinaServer();
        Server nginxProxy = new NginxProxy(sinaServer);
        System.out.println(nginxProxy.getPageTitle("http://www.sina.com.cn/"));
    }
}
