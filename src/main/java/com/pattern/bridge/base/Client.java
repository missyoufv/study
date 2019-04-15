package com.pattern.bridge.base;

public class Client {

    public static void main(String[] args)
    {
        Implementor imple = new ConcreteImplementorA();
        Abstraction abs = new RefinedAbstraction(imple);
        abs.Operation();
    }
}
