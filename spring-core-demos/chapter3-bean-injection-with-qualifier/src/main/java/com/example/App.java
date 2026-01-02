package com.example;

import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

  public static void main(String[] args) {

    var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

    Person p = context.getBean("person1", Person.class);

    System.out.println("Person's name: " + p.getName());
    System.out.println("Person's parrot: " + p.getParrot());

    Person p2 = context.getBean("person2", Person.class);

    System.out.println("Person's name: " + p2.getName());
    System.out.println("Person's parrot: " + p2.getParrot());

    context.close();
  }
}
