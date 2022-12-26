package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ProjectConfig {

    public WebClient webClient() {
        return WebClient.builder().build();
    }
}
