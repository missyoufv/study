package com.pattern.abstractFactory.abFactory;

import com.pattern.abstractFactory.base.User;
import com.pattern.abstractFactory.factoryMethod.IUser;

/**
 * 从客户端的代码中，我们只需要更改 IFactory factory=new MysqlFactory(); 为 IFactory factory=new OracleFactory();，就实现了数据库访问的切换。
 * 而且实际上我们这次代码的重构已经使用到了抽象工厂模式，抽象工厂可能表面上看起来貌似与工厂方法模式没什么区别，其实不然，所以我之前才说抽象工厂模式是基于工厂方法模式的。
 *
 * 只有一个User表的封装类和User表的操作类时，我们只用到了工厂方法模式，而且也只需要使用到工厂方法模式。但是显然现在我们的数据库已经不止一个User表了，
 * 而 MySQL 和 Oracle 又是两大不同的分类，所以解决这种涉及到多个产品系列的问题，就需要使用到专门解决这种问题的模式：抽象工厂模式。这时候再回过头去看DP对抽象工厂模式的
 * 定义就不难理解了。
 *
 * 所以抽象工厂与工厂方法模式的区别在于：抽象工厂是可以生产多个产品的，例如 MysqlFactory 里可以生产 MysqlUser 以及 MysqlLogin 两个产品，而这两个产品又是属于一个系列的，
 * 因为它们都是属于MySQL数据库的表。而工厂方法模式则只能生产一个产品，例如之前的 MysqlFactory 里就只可以生产一个 MysqlUser 产品。
 */
public class Client {

    public static void main(String[] args){

        User user=new User();
        Login login = new Login();

        // 只需要确定实例化哪一个数据库访问对象给factory
        // IFactory factory=new MysqlFactory();
        IFactory factory=new OracleFactory();

        // 已与具体的数据库访问解除了耦合
        IUser userOperation=factory.createUser();

        userOperation.getUser(1);
        userOperation.insert(user);

        // 已与具体的数据库访问解除了耦合
        ILogin loginOperation=factory.createLogin();

        loginOperation.insert(login);
        loginOperation.getLogin(1);

    }
}
