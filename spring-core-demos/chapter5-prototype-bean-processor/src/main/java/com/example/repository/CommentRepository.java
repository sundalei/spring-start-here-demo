package com.example.repository;

import com.example.model.Comment;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepository {

  public void processComment(Comment c) {
    System.out.println("Processing comment " + c.toString());
    c.setText(c.getText() + "_modified");
  }

  public void validateComment(Comment c) {
    System.out.println("Validating comment " + c.toString());
    c.setText(c.getText() + "_modified");
  }
}
