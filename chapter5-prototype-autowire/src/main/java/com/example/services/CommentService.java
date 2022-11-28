package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repositories.CommentRepository;

@Service
public class CommentService {
    
    @Autowired
    private CommentRepository commentRepository;

    public CommentService() {
        System.out.println("CommentService instance created!");
    }

    public CommentRepository getCommentRepository() {
        return commentRepository;
    }
}
