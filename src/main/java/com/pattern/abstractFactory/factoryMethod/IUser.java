package com.pattern.abstractFactory.factoryMethod;

import com.pattern.abstractFactory.base.User;

public interface IUser {

    public void insert(User user);
    public IUser getUser(int uid);

}
