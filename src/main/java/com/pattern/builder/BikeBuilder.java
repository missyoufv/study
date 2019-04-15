package com.pattern.builder;

/**
 * description:
 * 自行车生产线接口
 */
public interface BikeBuilder {
    // 组装轮胎
    public void buildTyres();
    // 组装车架
    public void buildFrame();
    // 组装GPS定位装置
    public void buildGPS();
    // 获取自行车
    public Bike getBike();
}