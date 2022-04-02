package com.example.demo.service;

import com.example.demo.domain.Post;
import com.example.demo.domain.dto.PostV2;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {
    List<Post> findAll();
    Post getPost(int id);
    void save(PostV2 p);
    void delete(int id);
//    void update(int id, Post p);
//    List<Post> getByAuthorName(String name);


}
