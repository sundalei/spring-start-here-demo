package com.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        var context = new ClassPathXmlApplicationContext("config.xml");
        
        Parrot parrot = context.getBean(Parrot.class);
        System.out.println(parrot.getName());

        context.close();
    }
}
