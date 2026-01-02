package com.example;

import com.example.config.ProjectConfig;
import com.example.model.Comment;
import com.example.services.CommentService;
import java.util.logging.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

  private static Logger logger = Logger.getLogger(App.class.getName());

  public static void main(String[] args) {

    var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

    var service = c.getBean(CommentService.class);

    Comment comment = new Comment();
    comment.setText("Demo comment");
    comment.setAuthor("Natasha");

    String value = service.publishComment(comment);

    logger.info(value);

    c.close();
  }
}
