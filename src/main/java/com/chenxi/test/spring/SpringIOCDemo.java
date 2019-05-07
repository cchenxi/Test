package com.chenxi.test.spring;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SpringIOCDemo {
    public static void main(String[] args) {
//        f1();
//        f2();
        f3();
    }

    private static void f1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application.xml");
        System.out.println("context 启动成功");
        MessageService messageService = applicationContext.getBean(MessageService.class);
        System.out.println(messageService.getMessage());
    }

    private static void f2() {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("application.xml"));
        MessageService messageService2 = bf.getBean(MessageService.class);
        System.out.println(messageService2.getMessage());

        Resource resource = new ClassPathResource("application.xml");
        try {
            InputStream inputStream = resource.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void f3() {
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        ApplicationContext context = new AnnotationConfigApplicationContext(MessageServiceImpl.class);

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.register(MessageServiceImpl.class);
//        context.refresh();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.chenxi.test.spring");
        context.refresh();

        MessageService messageService = context.getBean(MessageService.class);
        System.out.println(messageService.getMessage());
    }
}
