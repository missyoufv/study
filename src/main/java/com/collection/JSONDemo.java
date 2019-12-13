package com.collection;

import java.io.Serializable;

/**
 * @author: duw
 * @Date: 2019/9/10 17:08
 * @Description:
 */
public class JSONDemo {


    public static void main(String[] args) {
    }
}

class Student implements Serializable {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }



}
