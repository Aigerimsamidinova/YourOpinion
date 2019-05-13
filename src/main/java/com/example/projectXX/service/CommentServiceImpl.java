package com.example.projectXX.service;

import com.example.projectXX.model.Comment;
import com.example.projectXX.reposiroty.CommentRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CrudService<Comment>{
    @Autowired
    private CommentRep commentRep;

    @Override
    public List<Comment> getAll() {
        return commentRep.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return commentRep.findById(id).get();
    }

    @Override
    public Comment add(Comment comment) {
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
