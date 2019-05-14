package com.example.projectXX.reposiroty;

import com.example.projectXX.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRep
        extends JpaRepository<Comment, Long> {
}
