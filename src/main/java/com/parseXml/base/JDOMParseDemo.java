package com.parseXml.base;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.util.List;

public class JDOMParseDemo {

    public static void main(String[] args) {

        try {
            SAXBuilder builder = new SAXBuilder();
            Document doc = builder.build(JDOMParseDemo.class.getClassLoader().getResourceAsStream("parseXml/info.xml"));
            Element foo = doc.getRootElement();
            List allChildren = foo.getChildren();
            for (int i = 0; i < allChildren.size(); i++) {
                System.out.print("book name:"+ ((Element) allChildren.get(i)).getChild("name").getText());
                System.out.println("book author:"+ ((Element) allChildren.get(i)).getChild("author").getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
