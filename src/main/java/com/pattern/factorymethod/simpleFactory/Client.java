package com.pattern.factorymethod.simpleFactory;


/**
 * 如果需要在方法里写很多与对象创建有关的业务代码，而且需要的创建的对象还不少的话，我们是不是要在这个简单工厂类里编写很多个方法，
 * 每个方法里是不是得写很多相应的业务代码，而每次增加子类或者删除子类对象的创建是不是都需要打开这简单工厂类来进行修改？
 * 这不就很明显的会导致这个简单工厂类很庞大臃肿、耦合性高吗，而且增加、删除某个子类对象的创建都需要打开简单工厂类来进行修改代码也违反了开-闭原则，
 *
 *
 * 所以为了解决以上所提到的问题，就需要使用到工厂方法模式了，工厂方法模式是对简单工厂模式进一步的解耦，因为在工厂方法模式中是一个子类对应一个工厂类，
 * 而这些工厂类都实现于一个抽象接口。这相当于是把原本会因为业务代码而庞大的简单工厂类，拆分成了一个个的工厂类，这样代码就不会都耦合在同一个类里了，
 * 就像把一个大蛋糕切成了多个小蛋糕。
 */
public class Client {

    public static void main(String[] args) throws Exception {

        Operation add = EasyFactory.createOperation("+");
        Operation sub = EasyFactory.createOperation("-");
        Operation mul = EasyFactory.createOperation("*");

        System.out.println(add.getResult(1, 1));
        System.out.println(sub.getResult(1, 1));
        System.out.println(mul.getResult(1, 1));
    }
}
