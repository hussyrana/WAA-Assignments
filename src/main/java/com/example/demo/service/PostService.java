package com.example.demo.service;

import com.example.demo.domain.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();
    Post getPost(long id);
    void save(Post p);
    void delete(long id);
    void update(long id, Post p);
    List<Post> getByAuthorName(String name);


}
