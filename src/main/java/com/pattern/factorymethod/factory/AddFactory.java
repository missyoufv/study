package com.pattern.factorymethod.factory;

import com.pattern.factorymethod.simpleFactory.Add;
import com.pattern.factorymethod.simpleFactory.Operation;

// 加法类工厂
public class AddFactory implements Factory{

    public Operation createOperation() {
        System.out.println("加法运算");
        return new Add();
    }
}
