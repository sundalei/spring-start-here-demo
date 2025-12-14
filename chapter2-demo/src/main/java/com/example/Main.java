package com.example;

import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {

    var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

    Parrot parrot = context.getBean(Parrot.class);
    System.out.println(parrot.getName());

    String s = context.getBean(String.class);
    System.out.println(s);

    Integer n = context.getBean(Integer.class);
    System.out.println(n);

    context.close();
  }
}
