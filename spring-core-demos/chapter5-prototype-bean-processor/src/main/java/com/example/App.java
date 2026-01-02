package com.example;

import com.example.config.ProjectConfig;
import com.example.model.Comment;
import com.example.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
  public static void main(String[] args) {

    var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

    CommentService commentService = context.getBean(CommentService.class);

    for (int i = 0; i < 5; i++) {
      Comment comment = new Comment();
      comment.setText("comment " + i);
      comment.setAuthor("author " + i);
      commentService.sendComment(comment);
    }

    context.close();
  }
}
