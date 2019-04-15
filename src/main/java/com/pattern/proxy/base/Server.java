package com.pattern.proxy.base;

/**
 * 服务器接口，用于获取网站数据
 */
public interface Server {

    /**
     * 根据url获取页面标题
     */
    public String getPageTitle(String url);

}