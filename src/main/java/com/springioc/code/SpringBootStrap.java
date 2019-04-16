package com.springioc.code;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class SpringBootStrap {


    public static void main(String[] args) {

        simpleLoadContext();
    }

    public static void loadContext(){
        //启动spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:springIoc/application.xml");


        System.out.println("context 启动成功");

        // 从 context 中取出我们的 Bean，而不是用 new MessageServiceImpl() 这种方式
        MessageService messageService = context.getBean(MessageService.class);
        // 这句将输出: hello world
        System.out.println(messageService.getMessage());
    }

    /**
     * 直接使用BeanFactory作为容器对于spring的使用来说并不多见，在企业的应用中大多数都会使用的是ApplicationContext,
     * 这里只用于测试，方便更好的分析spring内部原理
     */
    public static  void simpleLoadContext(){
//        System.out.println(SpringBootStrap.class.getResource("").getPath()); //获取的是当前类所在目录的绝对路径
//        System.out.println(SpringBootStrap.class.getResource("/").getPath()); //获取的是classpath的根路径
//        System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());//获取的是classpath的根路径。
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("springIoc/application.xml"));
        Person person  = (Person) beanFactory.getBean("person");
        System.out.println(person.getName());
    }
}
