package com.pattern.template.base;

public class Client {

    public static void main(String[] args)
    {
        AbstractClass tm = new ConcreteClass();
        tm.TemplateMethod();
    }
}
