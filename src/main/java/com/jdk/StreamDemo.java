package com.jdk;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * jdk1.8 stream
 *
 * 两句话理解Stream：
 *
 * 1.Stream是元素的集合，这点让Stream看起来用些类似Iterator；
 * 2.可以支持顺序和并行的对原Stream进行汇聚的操作；
 *
 * 大家可以把Stream当成一个装饰后的Iterator。原始版本的Iterator，用户只能逐个遍历元素并对其执行某些操作；包装后的Stream，
 * 用户只要给出需要对其包含的元素执行什么操作，比如“过滤掉长度大于10的字符串”、“获取每个字符串的首字母”等，具体这些操作
 * 如何应用到每个元素上，就给Stream就好了！原先是人告诉计算机一步一步怎么做，现在是告诉计算机做什么，计算机自己决定怎么做。
 * 当然这个“怎么做”还是比较弱的。
 *
 * 参考 https://www.cnblogs.com/aoeiuv/p/5911692.html
 */
public class StreamDemo {
    public static void main(String[] args) {

        /**
         * 使用Stream的基本步骤：
         *
         * 1.创建Stream；
         * 2.转换Stream，每次转换原有Stream对象不改变，返回一个新的Stream对象（**可以有多次转换**）；
         * 3.对Stream进行聚合（Reduce）操作(如下 collect(Collectors.toList()))，获取想要的结果；
         */
        List<String> list = Arrays.asList("abc","efgs","aefsft","cab");
        List<String> filterList = list.stream().filter(param -> param.length() < 4).collect(Collectors.toList());
        filterList.forEach(System.out::println);
    }
}
