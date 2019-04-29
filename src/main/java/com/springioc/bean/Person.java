package com.springioc.bean;

public class Person {

    private String name = "lucy";

    private Product product;

    public Person(String name, Product product) {
        this.name = name;
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showInfo(){
        System.out.println("用户姓名："+ name +",产品id："+ product.getProductId() + ",产品："+product.getProductName());
    }
}
