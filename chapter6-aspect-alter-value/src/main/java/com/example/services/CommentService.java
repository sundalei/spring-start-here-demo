package com.example.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.model.Comment;

@Service
public class CommentService {
    
    private final Logger LOG = LoggerFactory.getLogger(CommentService.class);

    public String publishComment(Comment comment) {
        LOG.info("Publishing comment: " + comment.getText());
        return "SUCCESS";
    }
}
