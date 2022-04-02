package com.example.demo.controller;

import com.example.demo.domain.Comment;
import com.example.demo.domain.dto.CommentDto;
import com.example.demo.service.CommentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CommentController {
    @Autowired
    CommentService commentService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/posts/{postId}/comments")
    public List<Comment> getAllCommentsByPostId(@PathVariable("postId") int postId){
        return commentService.getAllCommentsByPostId(postId);
    }
    @PostMapping("/posts/{postId}/comments")
    public void addComment(@PathVariable("postId") int postId, @RequestBody Comment c){
        CommentDto cd = modelMapper.map(c, CommentDto.class);
        cd.setPostId(postId);
        commentService.addComment(cd);
    }
}
