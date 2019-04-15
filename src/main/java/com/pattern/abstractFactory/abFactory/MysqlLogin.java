package com.pattern.abstractFactory.abFactory;

public class MysqlLogin implements ILogin{

    public void insert(Login login) {
        System.out.println("对 MySQL 里的 Login 表插入了一条数据");
    }

    public Login getLogin(int id) {
        System.out.println("通过 uid 在 MySQL 里的 Login 表得到了一条数据");
        return null;
    }
}
