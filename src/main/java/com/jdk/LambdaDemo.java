package com.jdk;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/**
 * jdk1.8 支持lambda表达式
 * lambda
 *  表达式语法
 *  表达式可使用的变量
 *  表达式中的this概念
 *
 */

public class LambdaDemo {
    public static void main(String[] args) {
        new MathBook().study();

        List<String> list = Arrays.asList("abc","efg","aet","cab");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("排序后的顺序："+list);
        //lambda表达式 应用之一
        List<Integer> numList = Arrays.asList(10,5,2,3,6);
        //创建匿名内部类
        Collections.sort(numList,(a,b)->a-b);
        Collections.sort(numList, Comparator.comparingInt(a -> a));
        System.out.println(numList);

        List<Integer> numList1 = Arrays.asList(10,5,2,3,6);
        Collections.sort(numList1,(a,b)-> {return b-a;});
        System.out.println(numList1);
        new Thread(()-> System.out.println("hello lambda!")).start();



        //lambda表达式的一般语法

        /**
         * (Type1 param1, Type2 param2, ..., TypeN paramN) -> {
         *   statment1;
         *   statment2;
         *   //.............
         *   return statmentM;
         * }
         * 这是lambda表达式的完全式语法，后面几种语法是对它的简化,如下所示。
         */
        System.out.println("lambda表达式单参数语法实例");
        /**
         * 单参数语法
         *
         * param1 -> {
         *   statment1;
         *   statment2;
         *   //.............
         *   return statmentM;
         * }
         */
        List<String> upCaseList = list.stream().map(name-> name.toUpperCase()).collect(Collectors.toList());
        System.out.println(upCaseList);

        /**
         * 单语句语法
         * param1 -> statment
         */
        System.out.println("lambda表达式单语句语法实例");
        List<String> lowCaseList = list.stream().map(name->name.toLowerCase()).collect(Collectors.toList());
        System.out.println(lowCaseList);


        /**
         * 方法引用写法
         * Class or instance :: method
         */
        System.out.println("lambda表达式方法引用写法实例");
        List<String>  lowCaseList1= list.stream().map(String::toLowerCase).collect(Collectors.toList());
        System.out.println(lowCaseList1);

        /**
         * lambda表达式可使用的变量
         */
        System.out.println("lambda表达式可使用的变量");
        String outer = "lambda:";
        List<String> result = list.stream().map(param->{
            Long inner = System.currentTimeMillis();
            return outer + param + "-------"+ inner;
        }).collect(Collectors.toList());
        result.forEach(System.out::println);

        /**
         * lambda表达式可使用的变量总结
         *
         * ambda表达式可以访问给它传递的变量（如上param），访问自己内部定义的变量(如上inner)，同时也能访问它外部的变量(如上outer)。
         *
         * 不过lambda表达式访问外部变量有一个非常重要的限制：变量不可变（只是引用不可变，而不是真正的不可变）。
         *
         * 当在表达式内部修改outer= " ";时，IDE就会提示你：
         *
         * Local variable outer defined in an enclosing scope must be final or effectively final
         *
         * 编译时会报错。因为变量outer被lambda表达式引用，所以编译器会隐式的把其当成final来处理。
         *
         * 以前Java的匿名内部类在访问外部变量的时候，外部变量必须用final修饰。现在java8对这个限制做了优化，可以不用显示使用final修饰，但是编译器隐式当成final来处理。
         */

        new LambdaDemo().lambdaThisMethod(list);


    }
    /**
     *
     * lambda表达式中的this概念
     * 不能再静态方法中使用，会报错。
     *
     */

    public void lambdaThisMethod(List<String> list){
        System.out.println("lambda表达式中的this概念");
        List<String> lambdaThisList = list.stream().map(param->{
            System.out.println(this.getClass().getName());
            return param.toUpperCase();
        }).collect(Collectors.toList());
        System.out.println(lambdaThisList);
    }
}
