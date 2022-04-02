package com.example.demo.service;

import com.example.demo.domain.Comment;
import com.example.demo.domain.Post;
import com.example.demo.domain.User1;
import com.example.demo.domain.dto.User1Dto;

import java.util.List;

public interface User1Service {
    List<User1Dto> findAll();
    void save(User1 u);
    User1Dto findById(int id);
    List<Post> findPostsByUserId(int id);
    List<User1Dto> findUsersByPostsGreaterThan(int n);
    Comment getCommentOfPostOfUser(int userId, int postId, int commentId);
    void deleteUserById(int id);
}
