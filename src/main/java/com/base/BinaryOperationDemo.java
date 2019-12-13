package com.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: duw
 * @Date: 2019/11/25 17:28
 * @Description:  Lambda表达式集合分组、条件过滤、组装、去重、排序、转换、求和、最值
 */
public class BinaryOperationDemo {

    public static void main(String[] args) {
        System.out.println(-1 << 2);
        System.out.println(-1 >> 2);

        System.out.println(-3 << 2);
        System.out.println(-3 >> 2);

        System.out.println(1<<32);
        System.out.println(1<<33);
        System.out.println(1<<34);

        int num = -2;
        System.out.println(num << 28);

        int num1 = 2;
        System.out.println(~32);

        Integer i = 1;
        System.out.println(i.equals("1"));
        List<String> list = new ArrayList<>(Arrays.asList("a","b","c","d"));
        List<String> newList =  list.stream().filter(obj->!obj.equals("b")).collect(Collectors.toList());
        list.stream().forEach(obj->{
            obj = obj+1;
        });
        System.out.println(list);
        System.out.println(list);
        System.out.println(newList);
//        list.stream().forEach(obj->{
//            if("b".contains(obj)){
//               list.add("B");
                 // 遍历过程中不能修改原始素组长度
//            }
//        });
//        System.out.println(list);
        for(int j=0 ;j<list.size();j++){
            if(list.get(j).equals("b")){
                list.add("B");
            }
        }
        System.out.println(list);

        List<Student> studentList = new ArrayList<>();
        Student xiaom = new BinaryOperationDemo.Student(16,"zhangsan",false);
        Student lis = new BinaryOperationDemo.Student(20,"lisi",false);
        studentList.add(xiaom);
        studentList.add(lis);
        studentList.forEach(student -> {
            if(student.getAge() >18){
                student.setAdult(true);
            }
        });
        studentList.forEach(System.out::println);

        /**
         * lambda 表达式做分组处理
         */
        Student wangw = new BinaryOperationDemo.Student(16,"wangw",false);
        Student zhaol = new BinaryOperationDemo.Student(20,"zhaol",false);
        List<Student> stuList = new ArrayList<>();
        stuList.add(xiaom);
        stuList.add(lis);
        stuList.add(wangw);
        stuList.add(zhaol);
        Map<Integer,List<Student>> studentMap = stuList.stream().collect(Collectors.groupingBy(Student::getAge));
        studentMap.keySet().forEach(obj-> System.out.println("学生年龄:"+obj+":" + studentMap.get(obj)));

    }

    @Data
    @AllArgsConstructor
    @ToString
    static class Student{
        private Integer age;
        private String name;
        private boolean adult;
    }
}
