package com.example;

import com.example.config.ProjectConfig;
import com.example.services.CommentService;
import com.example.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
  public static void main(String[] args) {

    var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

    var s1 = c.getBean(CommentService.class);
    var s2 = c.getBean(UserService.class);
    var s3 = c.getBean(CommentService.class);

    boolean b1 = s1.getCommentRepository() == s2.getCommentRepository();
    boolean b2 = s1.getCommentRepository() == s3.getCommentRepository();

    System.out.println(b1);
    System.out.println(b2);

    c.close();
  }
}
