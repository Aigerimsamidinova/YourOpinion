package com.example.projectXX.reposiroty;

import com.example.projectXX.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRep
        extends JpaRepository<Question, Long> {
}
