package com.pattern.factorymethod.factory;

import com.pattern.factorymethod.simpleFactory.Operation;

public class Client {

    public static void main(String[] args) throws Exception {

        // 使用反射机制实例化工厂对象，因为字符串是可以通过变量改变的
        Factory addFactory = getFactoryInstance("com.pattern.factorymethod.factory.AddFactory");
        Factory subFactory = getFactoryInstance("com.pattern.factorymethod.factory.SubFactory");
        Factory mulFactory = getFactoryInstance("com.pattern.factorymethod.factory.MulFactory");

        // 通过工厂对象创建相应的实例对象
        Operation add = addFactory.createOperation();
        Operation sub = subFactory.createOperation();
        Operation mul = mulFactory.createOperation();

        System.out.println(add.getResult(1, 1));
        System.out.println(sub.getResult(1, 1));
        System.out.println(mul.getResult(1, 1));
    }

    static Factory getFactoryInstance(String nameSpace)throws Exception{
        return (Factory) Class.forName(nameSpace).newInstance();
    }
}
