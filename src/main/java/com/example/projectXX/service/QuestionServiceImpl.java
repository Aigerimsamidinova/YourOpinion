package com.example.projectXX.service;

import com.example.projectXX.model.Question;
import com.example.projectXX.reposiroty.QuestionRep;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuestionServiceImpl implements CrudService<Question> {
    @Autowired
    private QuestionRep questionRep;

    @Override
    public List<Question> getAll() {
        return questionRep.findAll();
    }

    @Override
    public Question findById(Long id) {
        return questionRep.findById(id).get();
    }

    @Override
    public Question save(Question question) {
        return questionRep.save(question);
    }

    @Override
    public Question update(Question question) {
        return questionRep.save(question);
    }

    @Override
    public void deleteById(Long id) {
questionRep.deleteById(id);
    }

    @Override
    public void deleteAll() {
questionRep.deleteAll();
    }
}
