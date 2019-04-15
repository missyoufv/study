package com.jdk;

public interface Book {
    /**
     * 在jdk1.8之前，接口中只允许有抽象方法，但是在1.8之后，接口中允许有一个非抽象的方法，但是必须使用default进行修饰，叫做扩展方法。
     */
    default void study(){
        System.out.println("jdk1.8扩展方法学习");
    }
}
