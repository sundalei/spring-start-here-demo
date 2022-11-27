package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.ProjectConfig;
import com.example.services.CommentService;

public class App {
    public static void main(String[] args) {

        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var cs1 = c.getBean("commentService", CommentService.class);
        var cs2 = c.getBean("commentService", CommentService.class);

        System.out.println(cs1);
        System.out.println(cs2);

        boolean b1 = cs1 == cs2;

        System.out.println(b1);

        c.close();
    }
}
