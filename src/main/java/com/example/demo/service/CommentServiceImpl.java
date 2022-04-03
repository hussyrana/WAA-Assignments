package com.example.demo.service;

import com.example.demo.domain.Comment;
import com.example.demo.domain.dto.CommentDto;
import com.example.demo.service.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentRepo commentRepo;
    @Autowired
    PostService postService;

    @Override
    public List<Comment> getAllCommentsByPostId(int postId) {
        return postService.getPost(postId).getComments();
    }

    @Override
    public void addComment(CommentDto cd) {
        Comment c = new Comment();
        c.setName(cd.getName());
        c.setPost(postService.getPost(cd.getPostId()));
        commentRepo.save(c);
    }
}
