package com.pattern.abstractFactory.abFactory;

import com.pattern.abstractFactory.factoryMethod.IUser;

public interface IFactory {

    public IUser createUser();
    public ILogin createLogin();
}
