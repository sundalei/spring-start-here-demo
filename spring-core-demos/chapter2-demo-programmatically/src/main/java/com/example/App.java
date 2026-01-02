package com.example;

import com.example.config.ProjectConfig;
import java.util.function.Supplier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

  public static void main(String[] args) {

    var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

    Parrot parrot = new Parrot();
    parrot.setName("Kiki");

    Supplier<Parrot> parrotSupplier = () -> parrot;

    context.registerBean("parrot1", Parrot.class, parrotSupplier, bd -> bd.setPrimary(true));

    Parrot p = context.getBean(Parrot.class);
    System.out.println(p.getName());

    context.close();
  }
}
