package com.example.services;

import com.example.model.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

  private final Logger LOG = LoggerFactory.getLogger(CommentService.class);

  public void publishComment(Comment comment) {
    LOG.info("Publishing comment: {}", comment.getText());
  }
}
