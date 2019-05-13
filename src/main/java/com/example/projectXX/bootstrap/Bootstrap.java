package com.example.projectXX.bootstrap;

import com.example.projectXX.model.User;
import com.example.projectXX.reposiroty.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner  {
@Autowired
   private UserRep userRep;


    @Override
    public void run(String... args) throws Exception {
User user = new User();
user.setEmail("serikovastik@gmail.com");
user.setName("Astik");
userRep.save(user);




}
    }