package com.example.demo.repo;

import com.example.demo.domain.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//import com.example.demo.domain.dto.PostV2;
//import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PostRepo extends CrudRepository<Post, Integer> {
    List<Post> findAll();
//    Post getPost(int id);
//    void save(Post p);
//    void delete(int id);
    //void update(int id, Post p);
    //List<Post> getByAuthorName(String name);
}
