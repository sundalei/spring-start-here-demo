package com.example.service;

import com.example.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final CommentRepository commentRepository;

  public UserService(CommentRepository commentRepository) {
    this.commentRepository = commentRepository;
  }

  public CommentRepository getCommentRepository() {
    return commentRepository;
  }
}
