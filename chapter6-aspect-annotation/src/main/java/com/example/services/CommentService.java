package com.example.services;

import com.example.ToLog;
import com.example.model.Comment;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

  private Logger logger = Logger.getLogger(CommentService.class.getName());

  public void publishComment(Comment comment) {
    logger.info("Publishing comment: " + comment.getText());
  }

  @ToLog
  public void deleteComment(Comment comment) {
    logger.info("Deleting comment: " + comment.getText());
  }

  public void editComment(Comment comment) {
    logger.info("Editing comment: " + comment.getText());
  }
}
