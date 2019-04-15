package com.pattern.decorator.base;

public class Client {

    public static void main(String[] args)
    {
        Component p = new ConcreteComponent();
        p.operation();
        System.out.println("---------------------------------");
        Component d= new ConcreteDecorator(p);
        d.operation();
    }
}
