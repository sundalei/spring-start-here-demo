package com.example.config;

import com.example.Parrot;
import com.example.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

  @Bean
  public Parrot parrot1() {
    Parrot p = new Parrot();
    p.setName("Koko");
    return p;
  }

  @Bean
  public Parrot parrot2() {
    Parrot p = new Parrot();
    p.setName("Miki");
    return p;
  }

  @Bean
  public Person person2(Parrot parrot2) {
    // Note: for this to work, ensure compiling with option -parameters
    Person p = new Person();
    p.setName("Ella");
    p.setParrot(parrot2);
    return p;
  }

  @Bean
  public Person person1(@Qualifier("parrot1") Parrot parrot) {
    Person p = new Person();
    p.setParrot(parrot);
    p.setName("John");
    return p;
  }
}
