package com.collection;

import java.util.*;
import java.util.concurrent.SynchronousQueue;

public class LinkDemo {


    public static void main(String[] args) throws Exception{
        String []array = new String[]{"1","5","10"};
        List list = new LinkedList(Arrays.asList(array));
        list.add("15");
        list.add(1,"3");
        list.add("20");
        System.out.println(list);

        TreeMap<String,String> map = new TreeMap<String, String>(new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        map.put("c", "1");
        map.put("a", "1");
        map.put("bb", "1");
        map.put("b", "1");

        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        SynchronousQueue synchronousQueue = new SynchronousQueue();
        boolean flag = synchronousQueue.offer("abc");
        System.out.println(flag);
    }
}
