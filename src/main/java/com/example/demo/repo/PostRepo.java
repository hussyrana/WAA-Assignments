package com.example.demo.repo;

import com.example.demo.domain.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PostRepo extends CrudRepository<Post, Integer> {

    List<Post> findAll();

    @Query("select p from Post p where p.title=:title")
    List<Post> findPostsByTitle(String title);

}
