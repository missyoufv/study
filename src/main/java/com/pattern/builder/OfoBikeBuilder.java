package com.pattern.builder;

/**
 * description:
 * ofo单车生产线
 */
public class OfoBikeBuilder implements BikeBuilder {
    // 拥有单车对象
    Bike bike = new Bike();
    @Override
    public void buildTyres() {
        bike.setTyre("黑色轮胎");
    }

    @Override
    public void buildFrame() {
        bike.setFrame("黄色车架");
    }

    @Override
    public void buildGPS() {
        bike.setGps("ofo定制版GPS定位装置");
    }

    @Override
    public Bike getBike() {
        return bike;
    }
}
