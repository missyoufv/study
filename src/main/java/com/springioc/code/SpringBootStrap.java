package com.springioc.code;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBootStrap {


    public static void main(String[] args) {

        //启动spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:springIoc/application.xml");


        System.out.println("context 启动成功");

        // 从 context 中取出我们的 Bean，而不是用 new MessageServiceImpl() 这种方式
        MessageService messageService = context.getBean(MessageService.class);
        // 这句将输出: hello world
        System.out.println(messageService.getMessage());
    }
}
