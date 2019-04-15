package com.pattern.abstractFactory.base;


/**
 * 从以上的客户端代码可以很明显到看到一个问题，就是MysqlUser mysqlUser=new MysqlUser();这一句代码使得mysqlUser 这个对象被写死在了MysqlUser 上。
 * 如果需求变更，数据库方面不用MySQL而改用Oracle了呢，那么与之有关联的代码都得需要进行更改。
 *
 * 这是因为代码上依赖了具体的实现类，导致与 MysqlUser 耦合，如果熟悉多态或工厂模式的话，可能就已经想到可以用工厂模式来改造它了，通过工厂方法模式可以封装 new MysqlUser();
 * 所造成的变化，因为工厂方法模式可以定义一个用于创建对象的接口，让子类决定实例化哪一个类。
 *
 * 其实即便是数据库中会有多个表，那也是属于数据访问这一类的，属于这一系列的，所以我们只需要增加一些相关的类即可。
 */
public class Client {

    public static void main(String[] args){

        User user=new User();

        MysqlUser mysqlUser=new MysqlUser();

        mysqlUser.insert(user);
        mysqlUser.getUser(1);
    }
}