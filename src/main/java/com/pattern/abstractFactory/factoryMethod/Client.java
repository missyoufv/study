package com.pattern.abstractFactory.factoryMethod;

import com.pattern.abstractFactory.base.User;

/**
 * 以上我们使用工厂方法模式重构的之前的代码，现在如果需求改变，要更换数据库，只需要把 MysqlFactory();
 * 改为 OracleFactory(); 就可以了，此时由于多态的特性，使得 IUser 接口的对象 userOperation 根本不知道是在访问哪个数据库，
 * 却可以在运行时很好的完成工作，这就是所谓的业务逻辑与数据访问的解耦。
 *
 *
 * 但是，问题还没有解决完，因为数据库里不可能只有一个表吧，很有可能会有其他表，比如与用户表相关的登录记录表（Login表），此时该如何解决？
 *
 * Login 类，封装 Login 表的数据，假设只有 id 和 date 两个字段：
 */
public class Client {

    public static void main(String[] args){

        User user=new User();

        IFactory factory=new MysqlFactory();
        IUser userOperation=factory.createUser();

        userOperation.getUser(1);
        userOperation.insert(user);

    }
}
