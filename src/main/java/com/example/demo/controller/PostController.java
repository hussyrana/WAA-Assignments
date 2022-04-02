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

//    @GetMapping(params = "name")
//    public List<PostV2> getPostsByAuthor(@RequestParam(value = "name", required = false) String name){
//        List<PostV2> postV2s = name == null ? (List<PostV2>) ProductListMapperToDto.mapList(postService.findAll(), new PostV2())
//                : (List<PostV2>) ProductListMapperToDto.mapList(postService.getByAuthorName(name), new PostV2());
//        return postV2s;
//
//    }


}
