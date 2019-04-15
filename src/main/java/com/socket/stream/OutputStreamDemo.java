package com.socket.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 对象 输入 输出流
 *
 * ObjectOutputStream 对象输出到流中
 * ObjectInputStream 流到对象
 */
public class OutputStreamDemo {

    public static void main(String[] args) {
        String filePath = "e://a.txt";
        Student s = new Student("张珊",22,"湖北武汉");
        Student s1 = new Student("杜伟",24,"广东深圳");
        List list = new ArrayList();
        list.add(s);
        list.add(s1);

        OutputStreamDemo demo = new OutputStreamDemo();
        demo.writeFile(filePath,list);

        List list1 = demo.readFile(filePath);
        System.out.println(list1);

    }

    public void writeFile(String filePath,Object obj){
        try{

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
            objectOutputStream.writeObject(obj);

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public  List readFile(String filePath){
        try{

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
            List<Student> list = (List<Student>) objectInputStream.readObject();
            return list;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
