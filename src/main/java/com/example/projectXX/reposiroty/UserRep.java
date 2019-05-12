package com.example.projectXX.reposiroty;

import com.example.projectXX.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRep  extends JpaRepository<User, Long> {
}
