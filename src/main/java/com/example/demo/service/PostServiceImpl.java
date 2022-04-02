package com.example.demo.service;

import com.example.demo.domain.Post;
import com.example.demo.domain.User1;
import com.example.demo.domain.dto.PostV2;
import com.example.demo.repo.PostRepo;
import com.example.demo.repo.User1Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepo postRepo;

    @Autowired
    User1Repo user1Repo;

    @Override
    public List<Post> findAll() {
        return postRepo.findAll();
    }

    @Override
    public Post getPost(int id) {
        return postRepo.findById(id).get();
    }

    @Override
    public void save(PostV2 p) {
        Post pp = new Post();
        pp.setAuthor(p.getAuthor());
        pp.setContent(p.getContent());
        pp.setTitle(p.getTitle());
        User1 user = user1Repo.findById(p.getUserId()).get();
        user.addPost(pp);
        //pp.setUser1(user);
        postRepo.save(pp);
    }

    @Override
    public void delete(int id) {
        postRepo.deleteById(id);
    }

//    @Override
//    public void update(int id, Post p) {
//        postRepo.update(id, p);
//    }
//
//    @Override
//    public List<Post> getByAuthorName(String name) {
//        return postRepo.getByAuthorName(name);
//    }
}
