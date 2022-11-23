package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(
    basePackages = { "com.example.proxies", "com.example.service", "com.example.repositories"}
)
public class ProjectConfiguration {
    
}
