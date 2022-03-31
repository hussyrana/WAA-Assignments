package com.example.demo.repo;

import com.example.demo.domain.Post;
import com.example.demo.domain.dto.PostV2;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepoImpl implements PostRepo{
    private static List<Post> posts;
    private static long postId=5;
    static {
        posts=new ArrayList<>();
        posts.add(new Post(1," WAA","Spring Boot and React", "Mahiyudeen"));
        posts.add(new Post(2," MWA","Node and angular", "Najeeb"));
    }
    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post getPost(long id) {
        return posts.stream().filter(p->p.getId()==id).findFirst().orElse(null);
    }

    @Override
    public void save(Post p) {
        p.setId(postId++);
        posts.add(p);
    }

    @Override
    public void delete(long id) {
        posts = posts.stream().filter(p->p.getId()!=id).toList();
    }

    @Override
    public void update(long id, Post p) {
        Post uPost = getPost(id);
        uPost.setTitle(p.getTitle());
        uPost.setContent((p.getContent()));
        uPost.setAuthor(p.getAuthor());
    }

    @Override
    public List<Post> getByAuthorName(String name) {
        return posts.stream().filter(p->p.getAuthor().equals(name)).toList();
    }
}
