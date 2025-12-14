package com.example;

import com.example.config.ProjectConfig;
import com.example.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
  public static void main(String[] args) {

    var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

    System.out.println("Before retrieving the CommentService");
    var service = c.getBean(CommentService.class);
    System.out.println("After retrieving the CommentService");

    System.out.println(service);

    c.close();
  }
}
