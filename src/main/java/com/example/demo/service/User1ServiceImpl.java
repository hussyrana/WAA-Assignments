package com.example.demo.service;

import com.example.demo.domain.Comment;
import com.example.demo.domain.Post;
import com.example.demo.domain.User1;
import com.example.demo.domain.dto.User1Dto;
import com.example.demo.helper.ListMapper;
import com.example.demo.repo.User1Repo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User1ServiceImpl implements User1Service {

    @Autowired
    User1Repo userRepo;

    @Autowired
    ListMapper listMapper;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<User1Dto> findAll() {
        return listMapper.mapList(userRepo.findAll(), new User1Dto());
    }

    @Override
    public void save(User1 u) {
        userRepo.save(u);
    }

    @Override
    public User1Dto findById(int id) {
        return modelMapper.map(userRepo.findById(id).orElse(null), User1Dto.class);
    }

    @Override
    public List<Post> findPostsByUserId(int id) {
        return userRepo.findById(id).orElse(null).getPosts();
    }

    @Override
    public List<User1Dto> findUsersByPostsGreaterThan(int n) {
        return listMapper.mapList(userRepo.findByPostGreaterThan(n), new User1Dto());
    }

    @Override
    public Comment getCommentOfPostOfUser(int userId, int postId, int commentId) {
        return userRepo.findById(userId).get().getPosts()
                .stream().filter(p->p.getId()==postId).findFirst().get().getComments()
                .stream().filter(c->c.getId()==commentId).findFirst().get();
    }

    @Override
    public void deleteUserById(int id) {
        userRepo.deleteById(id);
    }


}
