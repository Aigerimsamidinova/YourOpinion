package com.example.projectXX.service;

import com.example.projectXX.model.Comment;
import com.example.projectXX.model.Question;
import com.example.projectXX.reposiroty.QuestionRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class QuestionServiceImpl implements CrudService<Question>, QuestionService {
    @Autowired
    private QuestionRep questionRep;

    @Override
    public List<Question> getQuestionStatistics() {
        List<Question> questions = questionRep.findAll();
        Collections.sort(questions);
        Collections.reverse(questions);
        for(int i = 0; i < questions.size(); i++){
            List<Comment> comments = questions.get(i).getComments();
            Collections.sort(comments);
            Collections.reverse(comments);
            questions.get(i).setComments(comments);
        }
        return questions;
    }

    @Override
    public List<Question> getTop3Questions() {
        List<Question> questions = questionRep.findAll();
        List<Question> questionStatistics = new ArrayList<>();
        Collections.sort(questions);
        Collections.reverse(questions);
        if (3 <= questions.size()) {
            for (int i = 0; i < 3; i++) {
                List<Comment> comments = questions.get(i).getComments();
                Collections.sort(comments);
                Collections.reverse(comments);
                questions.get(i).setComments(comments);
                questionStatistics.add(questions.get(i));
            }
        } else {
            for (int i = 0; i < questions.size(); i++) {
                List<Comment> comments = questions.get(i).getComments();
                Collections.sort(comments);
                Collections.reverse(comments);
                questions.get(i).setComments(comments);
            }
            return questions;
        }
        return questionStatistics;
    }


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
