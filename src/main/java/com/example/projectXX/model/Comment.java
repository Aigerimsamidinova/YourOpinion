package com.example.projectXX.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Comment {
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
    @JoinColumn(name = "user_id")
    private List<User> users;

    // private List<UserCheck> checkUser;

    private String comment;

    public Comment() {
    }

    public Comment(String text) {
        this.text = text;
    }

    public Comment(String text, User user, Integer likes, Integer dislikes, List<User> users, String comment) {
        this.text = text;
        this.user = user;
        this.likes = likes;
        this.dislikes = dislikes;
        this.users = users;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
