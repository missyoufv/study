package com.collection;

import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * 集合工具类的使用
 */
public class CollectionsDemo {

    public static void main(String[] args) {

        invoke_random_list();
    }


    /**
     * 生成一个随机结合 或者将有序结合随机打乱
     *
     * 底层原理，遍历数组，指定位置和随机位置数据交换
     */
    public static void invoke_random_list() {
        Integer[] ia={0,1,2,3,4,5,6,7,8,9};
        Random random = new Random(100);
        List<Integer> list = new ArrayList<>(Arrays.asList(ia));
        System.out.println("before shuffle :" + list);
        Collections.shuffle(list,random);
        System.out.println("after shuffle :" + list);


        List<Integer> list1=Arrays.asList(ia);
        System.out.println("Before shuffling: "+list1);
        Collections.shuffle(list1,random);
        System.out.println("after shuffle :" + list1);

    }
}
