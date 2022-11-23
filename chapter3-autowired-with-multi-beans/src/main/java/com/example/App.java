package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.ProjectConfig;

public class App {
	public static void main(String[] args) {
		
		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		
		Person p = context.getBean(Person.class);
		
		System.out.println("Person's name: " + p.getName());
		System.out.println("Person's parrot: " + p.getParrot());
		
		context.close();
	}
}
