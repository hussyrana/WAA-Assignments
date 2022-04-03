package com.example.demo.service.repo;


import com.example.demo.domain.User1;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface User1Repo extends CrudRepository<User1, Integer> {
    List<User1> findAll();

    @Query("select u from User1 u where u.posts.size>:n")
    List<User1> findByPostGreaterThan(int n);
}
