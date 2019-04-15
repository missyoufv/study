package com.pattern.factorymethod.factory;

import com.pattern.factorymethod.simpleFactory.Mul;
import com.pattern.factorymethod.simpleFactory.Operation;

// 乘法类工厂
public class MulFactory implements Factory{

    public Operation createOperation() {
        System.out.println("乘法运算");
        return new Mul();
    }
}
