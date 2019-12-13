package com.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ListDemo {

    public static void main(String[] args) {

      method1();
//      method2();
//        method3();
    }

    /**
     * 在使用Iterator迭代过程中，不要使用集合操作元素，容易出现异常
     */
    public static void method1(){
        ArrayList list = new ArrayList();
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        System.out.println(list);
        Iterator it = list.iterator();
        //Iterator 接口  找到元素"abc2"，在后面添加一个"abc5"
        while (it.hasNext()) {
            Object obj = it.next();
            if (obj.equals("abc2")) {
                list.add("abc5");// Iterator没有增添元素的方法，只能去操作集合，所以发生异常
                it.remove();
            }
        }
        System.out.println(list);
    }


    /**
     * 在List集合有一个独特的迭代器ListIterator，它有自己的对集合操作修改的方法，可以在集合进行迭代过程中允许操作修改
     */
    public static void method2(){
        ArrayList list = new ArrayList();
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        System.out.println(list);
        ListIterator it = list.listIterator();//ListIterator 接口
        //Iterator 接口  找到元素"abc2"，在后面添加一个"abc5"
        while (it.hasNext()) {
            Object obj = it.next();
            if (obj.equals("abc2")) {
                it.add("abc5");// Iterator没有增添元素的方法，只能去操作集合，所以发生异常
            }
        }
        System.out.println(list);
    }

    /**
     * Iterator有它自己的对集合操作修改的方法，因而在迭代过程不会调用集合的方法，不会有异常
     */
    public static void method3(){
        ArrayList list = new ArrayList();
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        System.out.println(list);
        ListIterator it = list.listIterator();//ListIterator 接口
        //Iterator 接口  找到元素"abc2"，在后面添加一个"abc5"
        while (it.hasNext()) {
            Object obj = it.next();
            if (obj.equals("abc2")) {
                it.remove();// 调用Iterator自己的remove方法，不用去操作集合，所以不会发生异常
            }
        }
        System.out.println(list);
    }
}
