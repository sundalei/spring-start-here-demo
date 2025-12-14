package com.example.services;

import com.example.model.Comment;
import com.example.processor.CommentProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

  private final ApplicationContext context;

  public CommentService(ApplicationContext context) {
    this.context = context;
  }

  public void sendComment(Comment c) {
    CommentProcessor p = context.getBean(CommentProcessor.class);
    System.out.println(p);

    p.setComment(c);
    p.processComment(c);
    p.validateComment(c);

    c = p.getComment();
    System.out.println(c);
  }
}
