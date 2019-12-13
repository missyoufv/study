package com.base;

import java.util.*;

public class CollectionDemo {

    public static void main(String[] args) {

        List list = new ArrayList<String>();
        list.add("aa");
        list.add("bb");
        list.add("dd");
        list.add("cc");
        list.add("aa");

        Collections.sort(list, Comparator.reverseOrder());
        System.out.println(list);

        // 数组转集合的坑1  基础类型的数组转成list的时候，list存储的就是基础类型的地址 因此数组转集合要用引用类型
//        int [] intArrays = {1,3,5};
//        List intList = Arrays.asList(intArrays);
//        System.out.println(intList.size());
//        System.out.println(intList.get(0));
//        System.out.println(intList.get(1));

        // 数组转集合的坑2  基础类型的数组转成list的时候，list存储的就是基础类型的地址 因此数组转集合要用引用类型
//        Integer [] intArrays2 = {1,3,5};
//        List integerList = Arrays.asList(intArrays2);
//        System.out.println(integerList.size());
//        System.out.println(integerList.get(0));
//        System.out.println(integerList.get(1));
//        //Arrays.asList() 方法返回的并不是 java.util.ArrayList ，而是 java.util.Arrays 的一个内部类,这个内部类并没有实现集合的修改方法或者说并没有重写这些方法
//        integerList.add(5);
//        System.out.println(integerList);

        // 正确方法1
//        List list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        //正确方法2
//        Integer [] myArray = { 1, 2, 3 };
//        List myList = Arrays.stream(myArray).collect(Collectors.toList());

        //Collection.toArray()方法使用的坑&如何反转数组
        List<String> arrList = new ArrayList();
        arrList.add("aa");
        arrList.add("bb");
        // 由于JVM优化，new String[0]作为Collection.toArray()方法的参数现在使用更好，new String[0]就是起一个模板的作用，
        // 指定了返回数组的类型，0是为了节省空间，因为它只是为了说明返回的类型
        String []convertArr = arrList.toArray(new String[0]);
        System.out.println(convertArr);


        //不要在 foreach 循环里进行元素的 remove/add 操作 foreache 编译之后，是用的迭代器
        List<String> collectList = new ArrayList();
        collectList.add("1");
        collectList.add("2");

//        for(String item:collectList){
//            if("1".equals(item)){
//                collectList.add("3");
//            }
//        }
        // 用迭代器操作
        Iterator<String> iterator = collectList.iterator();
        while (iterator.hasNext()){
            String item = iterator.next();
            if("1".equals(item)){
//                iterator.remove();
//                不会报错，迭代器源码如下，若果list.remove() 然后break 也不会报错，因为迭代器next方法才会检测修改次数  checkForComodification
//                ArrayList.this.remove(lastRet);
//                cursor = lastRet;
//                lastRet = -1;
//                expectedModCount = modCount;
                collectList.remove(item);
                break;
                //
            }
        }
        System.out.println(collectList.toString());
    }
}
