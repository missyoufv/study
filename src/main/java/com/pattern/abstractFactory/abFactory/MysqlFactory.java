package com.pattern.abstractFactory.abFactory;

import com.pattern.abstractFactory.factoryMethod.IUser;
import com.pattern.abstractFactory.factoryMethod.MysqlUser;

public class MysqlFactory implements IFactory{

    public IUser createUser() {
        return new MysqlUser();
    }

    public ILogin createLogin() {
        return new MysqlLogin();
    }
}
