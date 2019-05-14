package com.example.projectXX.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

public class Commentary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Integer likes;
    private Integer dislikes;

    @OneToMany
    @JsonIgnore
    private List<User> users;

    @OneToMany
    @JsonIgnore
    private List<UserCheck> checkUser;
}
