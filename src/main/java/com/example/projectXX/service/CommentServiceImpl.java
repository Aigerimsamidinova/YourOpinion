package com.example.projectXX.service;

import com.example.projectXX.model.Comment;
import com.example.projectXX.model.Question;
import com.example.projectXX.reposiroty.CommentRep;
import com.example.projectXX.reposiroty.QuestionRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CommentServiceImpl implements CrudService<Comment>, CommentService {
    @Autowired
    private CommentRep commentRep;

    @Autowired
    private QuestionRep questionRep;

    @Override
    public List<Comment> getCommentsByTags(String tag) {
        List<Question> questions = questionRep.findAll();
        List<Comment> comments = new ArrayList<>();
        for (Question question : questions) {
            if (question.getTags().equals(tag)) {
                comments.addAll(question.getComments());
            }
        }
        return comments;
    }

    @Override
    public List<Comment> getQuestionCommentsByLikes(Long id) {
        List<Comment> comments = questionRep.findById(id).get().getComments();
        Collections.sort(comments);
        Collections.reverse(comments);
        return comments;
    }

    @Override
    public List<Comment> getAllCommentsByLikes() {
        List<Comment> comments = commentRep.findAll();
        Collections.sort(comments);
        Collections.reverse(comments);
        return comments;
    }

    @Override
    public List<Comment> getAll() {
        return commentRep.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return commentRep.findById(id).get();
    }

    @Override
    public Comment save(Comment comment) {
        return commentRep.save(comment);
    }

    @Override
    public Comment update(Comment comment) {
        return commentRep.save(comment);
    }

    @Override
    public void deleteById(Long id) {
        commentRep.deleteById(id);
    }

    @Override
    public void deleteAll() {
        commentRep.deleteAll();
    }
}
