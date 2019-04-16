package com.parseXml.base;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

public class DOMParseDemo {

    public static void main(String[] args) {

        long beginTime = System.currentTimeMillis();
        //创建一个DocumentBuilderFactory的对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try{
            //创建DocumentBuilder对象
            DocumentBuilder builder = factory.newDocumentBuilder();

            InputStream inputStream = DOMParseDemo.class.getClassLoader().getResourceAsStream("parseXml/info.xml");
            Document doc = builder.parse(inputStream);
            NodeList list = doc.getElementsByTagName("book");
            //list()方法可以获取bookList的长度
            for(int i = 0 ; i<list.getLength();i++){
                //通过 item(i)方法 获取一个book节点，nodelist的索引值从0开始
                Node book = list.item(i);
                //获取book节点的所有属性集合
//                NamedNodeMap attrs = book.getAttributes();

                //遍历book的属性
//                for (int j = 0; j < attrs.getLength(); j++) {
//                    //通过item(index)方法获取book节点的某一个属性
//                    Node attr = attrs.item(j);
//                    //获取属性名
//                    System.out.print("属性名：" + attr.getNodeName());
//                    //获取属性值
//                    System.out.println("--属性值" + attr.getNodeValue());
//                }

                //解析book节点的子节点
                NodeList childNodes = book.getChildNodes();
                //遍历childNodes获取每个节点的节点名和节点值
                for (int k = 0; k < childNodes.getLength(); k++) {
                    //区分出text类型的node以及element类型的node
                    if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
                        System.out.println("节点名："+ childNodes.item(k).getNodeName() + "节点值是：" + childNodes.item(k).getFirstChild().getNodeValue());
                    }
                }
            }

            System.out.println("解析耗时："+ (System.currentTimeMillis() - beginTime));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
