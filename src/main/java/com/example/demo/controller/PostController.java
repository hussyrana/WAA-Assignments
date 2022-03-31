package com.example.demo.controller;

import com.example.demo.domain.Post;
import com.example.demo.domain.dto.PostV2;
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
    ListMapper<Post, PostV2> ProductListMapperToDto;

    @GetMapping
    public List<Post> getPosts(){
        return postService.findAll();
    }

    @GetMapping(value="/{id}")
    public Post getPostById(@PathVariable("id") long id){
        return postService.getPost(id);
    }

    @GetMapping(value="/{id}", headers = "API-VERSION=2")
    public PostV2 getPostByIdV2(@PathVariable("id") long id){
        return modelMapper.map(postService.getPost(id), PostV2.class);
    }
    @PostMapping
    public void savePost(@RequestBody Post p){
        postService.save(p);
    }

    @DeleteMapping("/{id}")
    public void deletePostById(@PathVariable("id") long id){
        postService.delete(id);
    }

    @PutMapping("/{id}")
    public void updatePostById(@PathVariable("id") long id, @RequestBody Post p){
        postService.update(id, p);
    }

    @GetMapping(params = "name")
    public List<PostV2> getPostsByAuthor(@RequestParam(value = "name", required = false) String name){
        return name==null?(List<PostV2>)ProductListMapperToDto.mapList(postService.findAll(), new PostV2())
                :(List<PostV2>) ProductListMapperToDto.mapList(postService.getByAuthorName(name), new PostV2());

    }


}
