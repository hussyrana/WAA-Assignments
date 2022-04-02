package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private String title;
    private String content;
    private String author;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "post", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Comment> comments;
}
