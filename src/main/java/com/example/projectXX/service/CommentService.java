package com.example.projectXX.service;

import com.example.projectXX.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getQuestionCommentsByLikes(Long id);
    List<Comment> getAllCommentsByLikes();
}
