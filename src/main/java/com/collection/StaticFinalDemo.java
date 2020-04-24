package com.collection;

/**
 * static 和final的区别
 *
 *
 * final、static、static final修饰的字段赋值的区别？
 *  static修饰的字段在加载过程中准备阶段被初始化，但是这个阶段只会赋值一个默认的值（0或者null而并非定义变量设置的值）初始化阶段在类构造器中才会赋值为变量定义的值。
 *  （关于static的初始化请看"init"与"clinit"的区别）
 *
 *  final修饰的字段在运行时被初始化，可以直接赋值，也可以在实例构造器中赋值，赋值后不可修改。
 *
 *  final关键字对于变量的存储区域是没有任何影响的。jvm规范中，类的静态变量存储在方法区，实例变量存储在堆区。也就是说static关键字才对变量的存储区域造成影响。
 *
 *  final关键字来修饰变量表明了该变量一旦赋值就无法更改。同时编译器必须保证该变量在使用前被初始化赋值。
 *
 *  例如你的static final int c1这个变量，是一个静态变量，静态变量的初始化可以在静态块中进行。而非static变量，可以初始化块中和构造方法中进行。
 *
 *  如果你在这几个地方没有对final变量进行赋值，编译器便会报错。
 *
 *
 *  在一个类中定义字段时，可以声明为成员变量（如final），也可以声明为类变量（静态变量），静态变量在装载类时被初始化，而成员变量每次创建实例时都会被初始化一次。
 *  一个字段被声明为static final，表示这个字段在初始化完成后就不可再改变了，final，类的初始化完成后，在类的实例化进行赋值，每次实例化的值不一定相同。
 *  加上了static 的 final，在类只装载一次的情况下，可以是真正意义的“常量”
 */

public class StaticFinalDemo {

    private static final String a;

    private final String b;
    static {
        a = "xxjob";
    }
    StaticFinalDemo(String parm){
        this.b = parm;
    }
    public static void main(String[] args) {


    }
}
