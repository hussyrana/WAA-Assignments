package com.example.demo.service;

import com.example.demo.domain.Post;
import com.example.demo.domain.User1;
import com.example.demo.domain.dto.PostV2;
import com.example.demo.domain.dto.User1Dto;
import com.example.demo.helper.ListMapper;
import com.example.demo.service.repo.PostRepo;
import com.example.demo.service.repo.User1Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepo postRepo;

    @Autowired
    User1Repo user1Repo;

    @Autowired
    ListMapper<User1, User1Dto> listMapper;

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

    @Override
    public List<Post> findPostsByTitle(String title) {
        return postRepo.findPostsByTitle(title);
    }

    @Override
    public List<User1Dto> findUsersByPostTitle(String title) {
        List<User1> list = user1Repo.findAll().stream().filter(u->u.getPosts().stream().anyMatch(p->p.getTitle().equals(title))).toList();
        return (List<User1Dto>) listMapper.mapList(list, new User1Dto());
    }
}
