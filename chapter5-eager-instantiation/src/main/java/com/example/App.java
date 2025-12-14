package com.example;

import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
  public static void main(String[] args) {

    var c = new AnnotationConfigApplicationContext(ProjectConfig.class);
    // Eagerly instantiates all singletons which is the default behavior
    c.close();
  }
}
