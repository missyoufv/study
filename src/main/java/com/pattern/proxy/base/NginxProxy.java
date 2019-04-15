package com.pattern.proxy.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Nginx代理
 */
public class NginxProxy implements Server {

    /**
     * 新浪服务器列表
     */
    private static final List<String> SINA_SERVER_ADDRESSES = Arrays.asList(new String []{"192.168.1.1", "192.168.1.2", "192.168.1.3"});

    private Server server;

    public NginxProxy(Server server) {
        this.server = server;
    }

    @Override
    public String getPageTitle(String url) {
        // 这里就简单传了一个url，正常请求传入的是Request，使用UUID模拟请求原始Ip
        String remoteIp = UUID.randomUUID().toString();
        // 路由选择算法这里简单定义为对remoteIp的Hash值的绝对值取模
        int index = Math.abs(remoteIp.hashCode()) % SINA_SERVER_ADDRESSES.size();
        // 选择新浪服务器Ip
        String realSinaIp = SINA_SERVER_ADDRESSES.get(index);

        return "【页面标题：" + server.getPageTitle(url) + "】,【来源Ip：" + realSinaIp + "】";
    }

}