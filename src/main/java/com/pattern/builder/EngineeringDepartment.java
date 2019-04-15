package com.pattern.builder;

/**
 * description：
 * 工程部门作为指挥者，可以指导生产部门作业
 */
public class EngineeringDepartment {
    // 用户告知指挥者想要什么样的单车
    BikeBuilder bikeBuilder;
    public EngineeringDepartment(BikeBuilder bikeBuilder){
        this.bikeBuilder = bikeBuilder;
    }

    // 指导组装单车
    public void Construct(){
        bikeBuilder.buildTyres();
        bikeBuilder.buildFrame();
        bikeBuilder.buildGPS();
    }
}