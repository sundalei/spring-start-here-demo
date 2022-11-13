package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.Parrot;

@Configuration
public class ProjectConfig {
	
	@Bean
	Parrot parrot() {
		var p = new Parrot();
		p.setName("Koko");
		return p;
	}
	
	@Bean
	String hello() {
		return "Hello!";
	}
	
	@Bean
	Integer ten() {
		return 10;
	}
}
