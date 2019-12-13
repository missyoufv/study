package com.base;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
//        System.out.println(InitProperty.x);
//        InitProperty t1 = new InitProperty();
//        InitProperty t2 = new InitProperty();
//        t1.setX(3);
//        t2.setX(4);
//        System.out.println(t1.getX());
//        System.out.println(t2.getX());
//        Integer studyApi = null;
//        System.out.println(studyApi.equals(3));

//        Integer i = null;
//        System.out.println(i& 60);
//        testStr("http://oss.launcher.tcloudfamily.com/posters/0c53cb6baacd4376ba206e6ab84b9aaa.jpg?md5=f8fc3f9b7160aa0c9fb8b65eaff55a8b");
        Map<String,String> map = new HashMap<>();
        map.put("abc","x");
        map.put("efg",null);
        map.put("hgk","");
        Map<String,String> filterMap = fiterMap(map);
        filterMap.entrySet().stream().forEach(item-> System.out.println(item.getKey() + ":" + item.getValue()));

        testStrInit();
    }


    public static Map<String,String> fiterMap(Map<String,String> map){
        return map.entrySet().stream().filter(e->
            !StringUtils.isEmpty(e.getValue())
        ).collect(Collectors.toMap(e->e.getKey(),e->e.getValue()));
    }

    public static void testStrInit(){

        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);


    }
}
