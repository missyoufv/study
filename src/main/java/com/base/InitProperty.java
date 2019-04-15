package com.base;

public class InitProperty {

    public static int x =1;

    public InitProperty(){
        this.x =2;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public static void main(String[] args) {
        System.out.println(InitProperty.x);
        InitProperty t1 = new InitProperty();
        InitProperty t2 = new InitProperty();
        t1.setX(3);
        t2.setX(4);
        System.out.println(t1.getX());
        System.out.println(t2.getX());

    }
}
