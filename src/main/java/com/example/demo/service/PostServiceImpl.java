package com.example.demo.service;

import com.example.demo.domain.Post;
import com.example.demo.repo.PostRepo;
import com.example.demo.repo.PostRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepo postRepo;

    @Override
    public List<Post> findAll() {
        return postRepo.findAll();
    }

    @Override
    public Post getPost(long id) {
        return postRepo.getPost(id);
    }

    @Override
    public void save(Post p) {
        postRepo.save(p);
    }

    @Override
    public void delete(long id) {
        postRepo.delete(id);
    }

    @Override
    public void update(long id, Post p) {
        postRepo.update(id, p);
    }

    @Override
    public List<Post> getByAuthorName(String name) {
        return postRepo.getByAuthorName(name);
    }
}
