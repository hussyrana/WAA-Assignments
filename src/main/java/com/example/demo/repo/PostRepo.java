package com.example.demo.repo;

import com.example.demo.domain.Post;
import com.example.demo.domain.dto.PostV2;

import java.util.List;

public interface PostRepo {
    List<Post> findAll();
    Post getPost(long id);
    void save(Post p);
    void delete(long id);
    void update(long id, Post p);
    List<Post> getByAuthorName(String name);
}
