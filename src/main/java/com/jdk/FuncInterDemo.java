package com.jdk;


/**
 * jdk1.8 函数式接口
 *
 * 其实之前在讲Lambda表达式的时候提到过，所谓的函数式接口，当然首先是一个接口，然后就是在这个接口里面只能有一个抽象方法。
 *  函数式接口里允许定义默认方法
 *  函数式接口里允许定义静态方法
 *  函数式接口里是可以包含Object里的public方法，这些方法对于函数式接口来说，不被当成是抽象方法（虽然它们是抽象方法）；
 *      因为任何一个函数式接口的实现，默认都继承了Object类，包含了来自java.lang.Object里对这些抽象方法的实现；
 */
public class FuncInterDemo {

    public static void main(String[] args) {
        //函数式接口实现
        FuncInter funcInter = message -> System.out.println(message+"中国");
        //函数式接口调用
        funcInter.sayMessage("hello");
        funcInter.printHello();
        FuncInter.write();
        System.out.println(funcInter.equals("12"));
    }
}
