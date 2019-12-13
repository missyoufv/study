package com.jdk;

/**
 * 接口中只有一个抽象方法的接口，称为函数式接口，可以通过 Lambda 表达式来创建该接口的对象 (若 Lambda表达式抛出一个受检异常，
 * 那么该异常需要在目标接口的抽象方法上进行声明) 可以使用注解 @FunctionalInterface 修饰可以检查是否是函数式接口，
 * 同时 javadoc 也会包含一条声明，说明这个接口是一个函数式接口
 */
@FunctionalInterface
public interface FuncInter {

    /**
     * 函数式接口里是可以包含默认方法，因为默认方法不是抽象方法，其有一个默认实现，所以是符合函数式接口的定义的；
     * @param message
     */
    void sayMessage(String message);

    default void printHello(){
        System.out.println("函数式接口可以包含默认方法");
    }

    static void write(){
        System.out.println("good good study day day up");
    }
}
