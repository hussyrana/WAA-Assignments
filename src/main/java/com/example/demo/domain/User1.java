package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class User1 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany
    @JoinColumn(name = "userId")
    //@JsonManagedReference
    private List<Post> posts;

    public void addPost(Post p){
        posts.add(p);
    }
}
