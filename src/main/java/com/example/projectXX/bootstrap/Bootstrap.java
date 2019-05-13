package com.example.projectXX.bootstrap;

import com.example.projectXX.model.Category;
import com.example.projectXX.model.User;
import com.example.projectXX.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {
    @Autowired
    private CrudService<User> userCrudService;

    @Autowired
    private CrudService<Category> categoryCrudService;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setEmail("kanat.kg.98@mail.ru");
        user.setName("Kanat");
        userCrudService.save(user);

        User user1 = new User();
        user1.setEmail("islam321@mail.ru");
        user1.setName("Islam");
        userCrudService.save(user1);

        Category category = new Category();
        category.setName("Phones");
        categoryCrudService.save(category);
    }
}
