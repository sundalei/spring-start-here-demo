package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.ProjectConfig;
import com.example.model.Comment;
import com.example.services.CommentService;

public class App {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        CommentService commentService = context.getBean(CommentService.class);

        for (int i = 0; i < 5; i++) {
            Comment comment = new Comment();
            commentService.sendComment(comment);
        }

        context.close();
    }
}
