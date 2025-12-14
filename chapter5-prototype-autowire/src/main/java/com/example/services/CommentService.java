package com.example.services;

import com.example.repositories.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

  private final CommentRepository commentRepository;

  public CommentService(CommentRepository commentRepository) {
    System.out.println("CommentService instance created!");
    this.commentRepository = commentRepository;
  }

  public CommentRepository getCommentRepository() {
    return commentRepository;
  }
}
