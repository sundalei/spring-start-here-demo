package com.example.main;

import com.example.model.Comment;
import com.example.proxies.EmailCommentNotificationProxy;
import com.example.repositories.DBCommentRepository;
import com.example.service.CommentService;

public class Main {

  public static void main(String[] args) {

    var commentRepository = new DBCommentRepository();
    var commentNotificationProxy = new EmailCommentNotificationProxy();

    var commentService = new CommentService(commentRepository, commentNotificationProxy);

    var comment = new Comment("Laurentiu", "Demo comment");

    commentService.publishComment(comment);
  }
}
