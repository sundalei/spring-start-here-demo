package com.example.processor;

import com.example.repository.CommentRepository;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.model.Comment;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentProcessor {

  private Comment comment;

  private final CommentRepository commentRepository;

  public CommentProcessor(CommentRepository commentRepository) {
    this.commentRepository = commentRepository;
  }

  public void processComment(Comment c) {
    commentRepository.processComment(c);
  }

  public void validateComment(Comment c) {
    commentRepository.validateComment(c);
  }

  public Comment getComment() {
    return comment;
  }

  public void setComment(Comment comment) {
    this.comment = comment;
  }
}
