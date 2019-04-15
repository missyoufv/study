package com.pattern.abstractFactory.factoryMethod;

import com.pattern.abstractFactory.base.User;

public class OracleUser implements IUser{

    public void insert(User user) {
        System.out.println("对 Oracle 里的 User 表插入了一条数据");
    }

    public IUser getUser(int uid) {
        System.out.println("通过 uid 在 Oracle 里的 User 表得到了一条数据");
        return null;
    }
}