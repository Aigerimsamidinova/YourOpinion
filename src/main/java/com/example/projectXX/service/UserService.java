package com.example.projectXX.service;

import com.example.projectXX.model.Comment;
import com.example.projectXX.model.Question;

public interface UserService {
    Question addQuestion(Long userId, Long categoryId, Question question);
    Question addCommentToQuestion(Long userId, Long questionId, Comment comment);
    Question putMarkOnTheQuestion(Long userId, Long questionId, Character mark);
    Comment putMarkOnTheComment(Long userId, Long questionId, Long commentId, Character mark);
}
