package com.pattern.factorymethod.simpleFactory;

public class Add implements Operation{

    // 加法计算
    public double getResult(double numberA, double numberB) {

        return numberA + numberB;
    }
}