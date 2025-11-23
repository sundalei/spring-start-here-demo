package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.ProjectConfig;
import com.example.model.Comment;
import com.example.services.CommentService;

public class App {

    private static Logger LOG = LoggerFactory.getLogger(App.class);
    
    public static void main(String[] args) {

        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var service = c.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setText("Demo comment");
        comment.setAuthor("Natasha");

        String value = service.publishComment(comment);

        LOG.info(value);

        c.close();
    }
}
