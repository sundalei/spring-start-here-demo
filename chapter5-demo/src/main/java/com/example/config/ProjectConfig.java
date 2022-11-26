package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.service.CommentService;

@Configuration
public class ProjectConfig {
    
    @Bean
    public CommentService commentService() {
        return new CommentService();
    }
}
