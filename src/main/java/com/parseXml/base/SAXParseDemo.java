package xml.sax;

import com.parseXml.bean.Person;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.List;


/**
 * 开始编写SaxParserHandler，sax处理xml文件常用到一下五个方法，也是sax解析xml文件的流程：
 * startDocument —>文档读取开始
 * startElement —>标签读取开始
 * characters —>读取标签的内容
 * endElement —>标签读取结束
 * endDocument —>文档读取结束
 * sax处理xml文档时，首先会读取该文档，调用startDocument 方法，标志着xml文件解析的开始，然后是逐标签读取，方式是读取开始标签调用startElement、读取标签内容调用characters、读取结束标签调用endElement。
 */
public class SAXParseDemo extends DefaultHandler {

    public List<Person> list = null;
    Person person = null;
    String value = "";

    //文档开始
    @Override
    public void startDocument() throws SAXException {
//        super.startDocument();
        list = new ArrayList<>();
        System.out.println("解析开始");
    }

    //文档结束
    @Override
    public void endDocument() throws SAXException {
//        super.endDocument();
        System.out.println("解析结束");
    }

    //遍历开始标签
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (qName.trim().equals("Person")) {
            person = new Person();
            int id = Integer.parseInt(attributes.getValue("id"));
            person.setId(id);
        }
    }

    //遍历结束标签
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (qName.trim().equals("Person")) {
            list.add(person);
            person = null;
        } else if (qName.trim().equals("name"))
            person.setName(value);
        else if (qName.trim().equals("age"))
            person.setAge(Integer.parseInt(value));
        else if (qName.trim().equals("sex"))
            person.setSex(value);
    }

    //获取元素值
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        value = new String(ch, start, length);
        if (!value.trim().equals("")) {
            System.out.println(" && 节点值："+value);
        }
    }


    public static void main(String[] args) {

        try{
            //获取sax解析工厂
            SAXParserFactory factory = SAXParserFactory.newInstance();
            //通过工厂获取SaxParser实例
            SAXParser parser = factory.newSAXParser();
            //实例化自己创建的SAXParseDemo
            SAXParseDemo handler = new SAXParseDemo();
            parser.parse(SAXParseDemo.class.getClassLoader().getResourceAsStream("parseXml/person.xml"), handler);
            List<Person> list = handler.list;
            System.out.println(list.toString());
        }catch (Exception ex){
            ex.printStackTrace();
        }


    }
}
