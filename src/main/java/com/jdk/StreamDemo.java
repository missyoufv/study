package com.jdk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 1、获取stream方法
 * 2、stream方法使用
 */
public class StreamDemo {

    public static void main(String[] args) {

        getStream();
        invokeStreamMethod();
    }

    /**
     * stream 方法使用
     */
    private static void invokeStreamMethod() {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(9);
        list.add(3);

        // 迭代
        list.forEach(System.out::print);
        list.stream().forEach(i-> System.out.print(i + " "));
        System.out.println();
        // 小到大排序  Comparator.thenComparing 首先使用xx排序，紧接着在使用xxx排序，来看下使用效果 Comparator.reversed 进行大到小排序
        /**
         *  Collections.sort(employees, Comparator.comparing(Employee::getAge).thenComparing(Employee::getName));
         */
        list.stream().sorted(Comparator.comparingInt(a -> (int) a).reversed()).forEach(i -> System.out.print(i + " "));
        // 普通lambda排序
        list.sort((a,b)->a-b);
        System.out.println("lambda 排序结果"+list);

        /**
         * 过滤操作
         */
        System.out.println("过滤操作"+list.stream().filter(i->i>2).collect(Collectors.toList()));

        /**
         * 截断操作
         */
        System.out.println("截断操作"+ list.stream().limit(2).collect(Collectors.toList()));

        /**
         * skip()：与limit互斥，使用该方法跳过元素
         */
        System.out.println("跳过操作"+ list.stream().skip(2).collect(Collectors.toList()));

        /**
         * distinct()：使用该方法去重，注意：必须重写对应泛型的hashCode()和equals()方法
         */
        list.add(3);
        System.out.println("重复元素结合"+list);
        System.out.println("去重操作"+list.stream().distinct().collect(Collectors.toList()));
        /**
         * findFirst() ：使用该方法获取第一个元素
         */
        System.out.println("获取第一个元素操作"+list.stream().filter(i->i==3).findFirst().get());

        /**
         * map()：接收一个方法作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
         */
        System.out.println("map对每个元素的操作"+ list.stream().map(i->i+4).collect(Collectors.toList()));
    }

    /**
     * 获取stream的几种方法
     */
    private static void getStream() {
        // 值
        Stream<String> st1 = Stream.of("a","b","c");

        // 集合
        List<String> list = Arrays.asList("ab", "cd", "ef");
        Stream<String> st2 = list.stream();

        // 数组
        String [] arr = new String[]{"a","b","c"};
        Stream<String> str3 = Arrays.stream(arr);
    }
}
