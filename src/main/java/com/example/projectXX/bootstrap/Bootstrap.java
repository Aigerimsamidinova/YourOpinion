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
User user2 = new User();
user.setEmail("aidana@gmail.com");
user.setName("Aidana");
userRep.save(user2);
User user3 = new User();
user.setEmail("aigerim@gmail.com");
user.setName("Aigerim");
userRep.save(user3);
User user4 = new User();
user.setEmail("kanat@gmail.com");
user.setName("Kanat");
userRep.save(user4);
User user5 = new User();
user.setEmail("danil@gmail.com");
user.setName("Danil");
userRep.save(user5);




}
    }