package com.pattern.factorymethod.simpleFactory;

public class EasyFactory {

    // 简单工厂，根据字符串创建相应的对象
    public static Operation createOperation(String name) {
        Operation operationObj = null;
        switch (name) {
            case "+":
                operationObj = new Add();
                break;
            case "-":
                operationObj = new Sub();
                break;
            case "*":
                operationObj = new Mul();
                break;
        }
        return operationObj;
    }
}
