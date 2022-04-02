package com.example.demo.service;

import com.example.demo.domain.Comment;
import com.example.demo.domain.dto.CommentDto;

import java.util.List;

public interface CommentService {
    List<Comment> getAllCommentsByPostId(int postId);
    void addComment(CommentDto cd);
}
