package com.base;

/**
 * @author: duw
 * @Date: 2019/12/10 16:49
 * @Description: 实例化过程
 *
 * 1． 父类静态成员和静态初始化块 ，按在代码中出现的顺序依次执行
 * 2． 子类静态成员和静态初始化块 ，按在代码中出现的顺序依次执行
 * 3． 父类实例成员和实例初始化块 ，按在代码中出现的顺序依次执行
 * 4． 父类构造方法
 * 5． 子类实例成员和实例初始化块 ，按在代码中出现的顺序依次执行
 * 6． 子类构造方法
 */


class ClassInitDemo extends Base {


    private String name = "Java3y";

    public ClassInitDemo() {
        tellName();
        printName();
    }

    public void tellName() {
        System.out.println("Dervied tell name: " + name);
    }


    public static void main(String[] args) {

        new ClassInitDemo();
    }
}

class Base {

    protected String name = "xxx";

    public Base() {
        tellName();
        printName();
    }

    public void tellName() {
        System.out.println("Base tell name: " + name);
    }

    public void printName() {
        System.out.println("Base print name: " + name);
    }
}


