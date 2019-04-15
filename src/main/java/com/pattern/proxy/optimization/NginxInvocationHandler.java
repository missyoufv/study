package com.pattern.proxy.optimization;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Nginx InvocationHandler
 */
public class NginxInvocationHandler implements InvocationHandler {

    /**
     * 新浪服务器列表
     */
    private static final List<String> SINA_SERVER_ADDRESSES = Arrays.asList(new String []{"192.168.1.1", "192.168.1.2", "192.168.1.3"});

    private Object object;

    public NginxInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String remoteIp = UUID.randomUUID().toString();
        int index = Math.abs(remoteIp.hashCode()) % SINA_SERVER_ADDRESSES.size();
        String realSinaIp = SINA_SERVER_ADDRESSES.get(index);

        StringBuilder sb = new StringBuilder();
        sb.append("【页面标题：");
        sb.append(method.invoke(object, args));
        sb.append("】,【来源Ip：");
        sb.append(realSinaIp);
        sb.append("】");
        return sb.toString();
    }
}
