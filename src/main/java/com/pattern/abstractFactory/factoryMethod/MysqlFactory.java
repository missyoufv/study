package com.pattern.abstractFactory.factoryMethod;

public class MysqlFactory implements IFactory{

    public IUser createUser() {
        return new MysqlUser();
    }
}
