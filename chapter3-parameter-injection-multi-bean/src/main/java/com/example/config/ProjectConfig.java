package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.Parrot;
import com.example.Person;

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
	public Person person(Parrot parrot2) {
		Person p = new Person();
		p.setName("Ella");
		p.setParrot(parrot2);
		return p;
	}
}
