package com.pattern.abstractFactory.factoryMethod;

public class OracleFactory implements IFactory{

    public IUser createUser() {
        return new OracleUser();
    }
}
