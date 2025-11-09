package com.example.services;

import org.springframework.stereotype.Service;

import com.example.repositories.CommentRepository;

@Service
public class UserService {

  private final CommentRepository commentRepository;

  public UserService(CommentRepository commentRepository) {
    System.out.println("UserService instance created!");
    this.commentRepository = commentRepository;
  }

  public CommentRepository getCommentRepository() {
    return commentRepository;
  }
}
