package com.pattern.observer.base;

//具体观察者1
class ConcreteObserver1 implements Observer{

    public void response()
    {
        System.out.println("具体观察者1作出反应！");
    }
}
