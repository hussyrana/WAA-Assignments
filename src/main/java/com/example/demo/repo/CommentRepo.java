package com.example.demo.repo;

import com.example.demo.domain.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepo extends CrudRepository<Comment, Integer> {
    List<Comment> findAll();
}
