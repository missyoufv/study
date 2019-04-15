package com.pattern.factorymethod.factory;

import com.pattern.factorymethod.simpleFactory.Operation;
import com.pattern.factorymethod.simpleFactory.Sub;

// 减法类工厂
public class SubFactory implements Factory{

    public Operation createOperation() {
        System.out.println("减法运算");
        return new Sub();
    }
}
