package com.example.projectXX.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String headLine;
    private  String mainPart;
    private  String tags;
    private  Integer likes;
    private  Integer dislikes;
    @OneToMany
    private List<Commentary> commentaries;
    @ManyToOne
    @JoinColumn(name ="category_id")
    private  Category category;
    @JoinColumn(name ="user_id")
    private  User user;
    @OneToMany
    @JsonIgnore
    private List<User> users;
   @OneToMany
    @JsonIgnore
    private List<UserCheck> userChecks;

    public Question(Long id, String headLine, String mainPart,
                    String tags, Integer likes, Integer dislikes,
                    List<Commentary> commentaries, Category category,
                    User user, List<User> users, List<UserCheck> userChecks) {
        this.id = id;
        this.headLine = headLine;
        this.mainPart = mainPart;
        this.tags = tags;
        this.likes = likes;
        this.dislikes = dislikes;
        this.commentaries = commentaries;
        this.category = category;
        this.user = user;
        this.users = users;
        this.userChecks = userChecks;
    }

    public String getHeadLine() {
        return headLine;
    }

    public void setHeadLine(String headLine) {
        this.headLine = headLine;
    }

    public String getMainPart() {
        return mainPart;
    }

    public void setMainPart(String mainPart) {
        this.mainPart = mainPart;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
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

    public List<Commentary> getCommentaries() {
        return commentaries;
    }

    public void setCommentaries(List<Commentary> commentaries) {
        this.commentaries = commentaries;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<UserCheck> getUserChecks() {
        return userChecks;
    }

    public void setUserChecks(List<UserCheck> userChecks) {
        this.userChecks = userChecks;
    }
}
