package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.Parrot;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {
	
	@Bean
	Parrot parrot1() {
		var p = new Parrot();
		p.setName("Koko");
		return p;
	}
	
	@Bean
	@Primary
	Parrot parrot2() {
		var p = new Parrot();
		p.setName("Miki");
		return p;
	}
	
	@Bean
	Parrot parrot3() {
		var p = new Parrot();
		p.setName("Riki");
		return p;
	}
}
