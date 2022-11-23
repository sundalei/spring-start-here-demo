package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.Parrot;

@Configuration
@ComponentScan(basePackages = "com.example")
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
}
