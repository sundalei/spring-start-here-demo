package com.example.proxies;

import com.example.model.Comment;
import org.springframework.stereotype.Component;

@Component
public class EmailCommentNotificationProxy implements CommentNotificationProxy {

    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending mail notification for comment: " + comment.getText());
    }
}
