package com.jdk;

import java.util.function.Consumer;

/**
 * @author: duw
 * @Date: 2019/9/19 15:12
 * @Description: lambda表达式方法引用使用时间
 * 方法引用语法格式有以下三种：
 *         objectName::instanceMethod  引用静态方法
 *         ClassName::staticMethod  引用特定对象的实例方法
 *         ClassName::instanceMethod 引用构造函数
 *         ContainingType::methodName 引用特定类型的任意对象的实例方法
 */
public class MethodReferenceDemo {


    private String name = "good lucky";

    public interface Say{

        void run();
    }

    public void invoke(Say say){
        System.out.println(say.getClass().getName());
        say.run();
    }

    public void invoke(Consumer<String> consumer){
        consumer.accept(name);
    }

    public static void showName(String name){
        System.out.println("我的名字是"+name);
    }

    public void job(String job){
        System.out.println("good job");
    }

    public static void main(String[] args) {

        MethodReferenceDemo methodReferenceDemo = new MethodReferenceDemo();
        methodReferenceDemo.invoke(new SayHello()::run);

        System.out.println("\n-----------\n");
        // 引用构造函数
        methodReferenceDemo.invoke(SayHello::new);
        // 应用静态方法
        methodReferenceDemo.invoke(MethodReferenceDemo::showName);
        // 应用对象的实例方法
        methodReferenceDemo.invoke(methodReferenceDemo::job);
    }
}
class SayHello implements MethodReferenceDemo.Say{


    public SayHello() {
        System.out.println("SayHello 构造方法");
    }

    @Override
    public void run() {
        System.out.println("Hello");
    }
}
