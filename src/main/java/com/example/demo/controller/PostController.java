package com.example.demo.controller;

import com.example.demo.domain.Post;
import com.example.demo.domain.dto.PostDto;
import com.example.demo.domain.dto.PostV2;
import com.example.demo.domain.dto.User1Dto;
import com.example.demo.helper.ListMapper;
import com.example.demo.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    @Autowired
    PostService postService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<Post, PostDto> ProductListMapperToDto;

    @GetMapping
    public List<Post> getPosts(){
        return postService.findAll();
    }

    @GetMapping(value="/{id}")
    public Post getPostById(@PathVariable("id") int id){
        return postService.getPost(id);
    }

    @GetMapping(value="/{id}", headers = "API-VERSION=2")
    public PostV2 getPostByIdV2(@PathVariable("id") int id){
        return modelMapper.map(postService.getPost(id), PostV2.class);
    }
    @PostMapping
    public void savePost(@RequestBody PostV2 p){
        postService.save(p);
    }

    @DeleteMapping("/{id}")
    public void deletePostById(@PathVariable("id") int id){
        postService.delete(id);
    }

//    @PutMapping("/{id}")
//    public void updatePostById(@PathVariable("id") int id, @RequestBody Post p){
//        postService.update(id, p);
//    }

    @GetMapping(params = "title")
    public List<PostDto> getPostsByTitle(@RequestParam(value = "title", required = false) String title){
        List<PostDto> postDtos = (List<PostDto>) ProductListMapperToDto.mapList(postService.findPostsByTitle(title), new PostDto());
        return postDtos;

    }
    @GetMapping(value = "/users", params = "title")
    public List<User1Dto> getUsersByPostTitle(@RequestParam(value = "title", required = false) String title){
        return postService.findUsersByPostTitle(title);

    }


}
