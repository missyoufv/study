package com.pattern.builder;

/**
 * description:
 * 摩拜单车生产线
 */
public class MoBikeBuilder implements BikeBuilder {
    // 拥有单车对象
    Bike bike = new Bike();
    @Override
    public void buildTyres() {
        bike.setTyre("橙色轮胎");
    }

    @Override
    public void buildFrame() {
        bike.setFrame("橙色车架");
    }

    @Override
    public void buildGPS() {
        bike.setGps("mobike定制版GPS定位装置");
    }

    @Override
    public Bike getBike() {
        return bike;
    }
}
