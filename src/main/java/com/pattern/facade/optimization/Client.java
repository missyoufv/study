package com.pattern.facade.optimization;

/**
 * 由于Facade的作用，客户端可以根本不知道子系统类的存在，只需要对Facade对象进行操作即可
 *
 * 如上，可以看到，客户端只需要对Facade操作即可，不需要一个个的去对子系统类进行操作。这种模式用得挺多的，因为它完美的体现了依赖倒转原则以及迪米特法则的思想。
 *
 * 使用外观模式重构之前的代码，增加一个外观类：
 *
 */
public class Client {

    public static void main(String[] args) {

        Facade facade = new Facade();

        facade.MethodA();
        facade.MethodB();

    }
}
