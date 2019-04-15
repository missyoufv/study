package com.jvm;

import java.util.ArrayList;
import java.util.List;

public class HelloWorld {
    public static void main(String[] args) {

        List<Person> list = new ArrayList<Person>();
        long start = System.currentTimeMillis();
        System.out.println("start : " + start);
        int i = 0;
        while (i < 1000) {
            Person p = new Person();
            p.setAge(i);
            p.setName("xiaoming" + i);
            i++;
            list.add(p);
        }
        long end = System.currentTimeMillis();
        System.out.println("end : " + end);
        System.out.println("end - start : " + (end - start));
    }
}

class Person {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(){
        int []m = new int [1024 * 1024 * 50 * 2 * 2 ];//注意此处构造了一个800M的数组
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}