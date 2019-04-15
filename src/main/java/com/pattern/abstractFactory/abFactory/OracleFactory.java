package com.pattern.abstractFactory.abFactory;

import com.pattern.abstractFactory.factoryMethod.IUser;
import com.pattern.abstractFactory.factoryMethod.OracleUser;

public class OracleFactory implements IFactory{

    public IUser createUser() {
        return new OracleUser();
    }

    public ILogin createLogin() {
        return new OracleLogin();
    }
}
