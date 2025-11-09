package com.example.services;

import org.springframework.stereotype.Service;

import com.example.repositories.CommentRepository;

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
