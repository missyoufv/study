package com.jdk;

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

    @Override
    boolean equals(Object obj);
}
