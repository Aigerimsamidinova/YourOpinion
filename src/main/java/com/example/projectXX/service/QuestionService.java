package com.example.projectXX.service;

import com.example.projectXX.model.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getQuestionStatistics();
    List<Question> getTop3Questions();
}
