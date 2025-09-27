package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.ProjectConfig;

public class App {
	
	public static void main(String[] args) {
		
		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		
		Parrot p = context.getBean("parrot1", Parrot.class);
		
		System.out.println(p.getName());

        p = context.getBean(Parrot.class);

        System.out.println(p.getName());

        p = context.getBean("riki", Parrot.class);

        System.out.println(p.getName());

		context.close();
	}
}
