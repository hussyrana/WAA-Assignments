package com.example.demo.controller;

import com.example.demo.aspect.annotation.LoggerAnnotation;
import com.example.demo.domain.Comment;
import com.example.demo.domain.Post;
import com.example.demo.domain.User1;
import com.example.demo.domain.dto.User1Dto;
import com.example.demo.service.User1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class User1Controller {

    @Autowired
    User1Service user1Service;

    @GetMapping
    public List<User1Dto> findAll(){
        return user1Service.findAll();
    }

    @PostMapping
    public void add(@RequestBody User1 user){
        user1Service.save(user);
    }


    @GetMapping("/{id}")
    @LoggerAnnotation
    public User1Dto getUserById(@PathVariable("id") int id){
        return user1Service.findById(id);
    }
    @GetMapping("/{id}/posts")
    public List<Post> getPostsByUserId(@PathVariable("id") int id){
        return user1Service.findPostsByUserId(id);
    }
    @GetMapping(params = "postFilter")
    public List<User1Dto> getUsersByPostsGreaterThan(@RequestParam int postFilter){
        return user1Service.findUsersByPostsGreaterThan(postFilter);
    }
    @GetMapping("/{userId}/posts/{postId}/comments/{commentId}")
    public Comment getCommentOfPostOfUser(@PathVariable("userId") int userId, @PathVariable("postId") int postId, @PathVariable("commentId") int commentId){
        return user1Service.getCommentOfPostOfUser(userId, postId, commentId);
    }
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") int id){
        user1Service.deleteUserById(id);
    }

}
