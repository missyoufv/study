package com.parseXml.base;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.Iterator;

public class DOM4jParseDemo {

    public static void main(String[] args) {

        try {
            InputStream inputStream = DOMParseDemo.class.getClassLoader().getResourceAsStream("parseXml/info.xml");
            SAXReader reader = new SAXReader();
            Document doc = reader.read(inputStream);
            Element root = doc.getRootElement();
            Element foo;
            for (Iterator i = root.elementIterator("book"); i.hasNext();) {
                foo = (Element) i.next();
                System.out.print("book name:" + foo.elementText("name"));
                System.out.println("book author:" + foo.elementText("author"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
