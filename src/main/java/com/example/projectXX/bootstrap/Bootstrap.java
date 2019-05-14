package com.example.projectXX.bootstrap;

import com.example.projectXX.model.Category;
import com.example.projectXX.model.Comment;
import com.example.projectXX.model.Question;
import com.example.projectXX.model.User;
import com.example.projectXX.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Bootstrap implements CommandLineRunner {
    @Autowired
    private CrudService<User> userCrudService;

    @Autowired
    private CrudService<Category> categoryCrudService;

    @Autowired
    private CrudService<Comment> commentCrudService;

    @Autowired
    private CrudService<Question> questionCrudService;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setEmail("kanat321@mail.ru");
        user.setName("Kanat");
        userCrudService.save(user);

        User user1 = new User();
        user1.setEmail("islam321@mail.ru");
        user1.setName("Islam");
        userCrudService.save(user1);

        User user2 = new User();
        user2.setEmail("astan321@mail.ru");
        user2.setName("Astan");
        userCrudService.save(user2);

        Category category = new Category();
        category.setName("Phones");
        categoryCrudService.save(category);

        Comment c1 = new Comment();
        c1.setUser(user2);
        c1.setText("Пользуюсь 3 месяц. Жалею, что купила. При разговоре часто отключается");
        c1.setLikes(5);
        c1.setDislikes(2);
        commentCrudService.save(c1);

        Comment c2 = new Comment();
        c2.setUser(user);
        c2.setText("Одним словом крутой СМАРТФОН!");
        c2.setLikes(1);
        c2.setDislikes(10);
        commentCrudService.save(c2);

        Comment c3 = new Comment();
        c3.setUser(user);
        c3.setText("Удобный телефон за свою цену");
        c3.setLikes(2);
        c3.setDislikes(4);
        commentCrudService.save(c3);

        Comment c4 = new Comment();
        c4.setUser(user2);
        c4.setText("Хороший аккумулятор, удобный экран, стильный дизайн, Жирный плюс-цена!!");
        c4.setLikes(15);
        c4.setDislikes(2);
        commentCrudService.save(c4);

        List<Comment> comments = new ArrayList<>();
        comments.add(c1);
        comments.add(c2);
        comments.add(c3);
        comments.add(c4);

        Question q1 = new Question();
        q1.setHeadLine("Xiaomi Redmi 5");
        q1.setMainPart("Говорят что батарейка держится отлично, но сбрасывает при разговоре, " +
                "что можете сказать на счет этого ?");
        q1.setTags("#XiaomiRedmi5 #Xiaomi #XiaomiRedmi");
        q1.setComments(comments);
        q1.setLikes(5);
        q1.setDislikes(1);
        q1.setCategory(category);
        q1.setUser(user1);
        questionCrudService.save(q1);

        Comment c5 = new Comment();
        c5.setUser(user1);
        c5.setText("Всем советую именно эту модель");
        c5.setLikes(1);
        c5.setDislikes(7);
        commentCrudService.save(c5);

        Comment c6 = new Comment();
        c6.setUser(user);
        c6.setText("В нем все идеально, действительно стоит покупать");
        c6.setLikes(0);
        c6.setDislikes(11);
        commentCrudService.save(c6);

        Comment c7 = new Comment();
        c7.setUser(user1);
        c7.setText("Камера отличная, особенно после обновления, " +
                "дизайн не сильно отличается, но такой же классный как и на 6");
        c7.setLikes(7);
        c7.setDislikes(2);
        commentCrudService.save(c7);

        Comment c8 = new Comment();
        c8.setUser(user);
        c8.setText("Пользуюсь уже год и не обнаружила минусов");
        c8.setLikes(4);
        c8.setDislikes(1);
        commentCrudService.save(c8);

        List<Comment> comments1 = new ArrayList<>();
        comments1.add(c5);
        comments1.add(c6);
        comments1.add(c7);
        comments1.add(c8);

        Question q2 = new Question();
        q2.setHeadLine("Iphone 7 plus");
        q2.setMainPart("Хочу купить себе Iphone 7 plus, стоит ли покупать ?");
        q2.setTags("#Iphone #Iphone7plus #Iphone7");
        q2.setComments(comments1);
        q2.setLikes(17);
        q2.setDislikes(0);
        q2.setCategory(category);
        q2.setUser(user2);
        questionCrudService.save(q2);

        Comment c9 = new Comment();
        c9.setUser(user1);
        c9.setText("Телефон нравится не смотря на проблему с защитными стеклами");
        c9.setLikes(3);
        c9.setDislikes(1);
        commentCrudService.save(c9);

        Comment c10 = new Comment();
        c10.setUser(user2);
        c10.setText("Закругленные края, стекло клеится по краям, потом отклеиваются и деньги на ветер за стекло");
        c10.setLikes(19);
        c10.setDislikes(5);
        commentCrudService.save(c10);

        Comment c11 = new Comment();
        c11.setUser(user1);
        c11.setText("Надо купить стекло с uv-клеем, тогда все будет идеально");
        c11.setLikes(22);
        c11.setDislikes(2);
        commentCrudService.save(c11);

        Comment c12 = new Comment();
        c12.setUser(user2);
        c12.setText("Телефон отличный, камера , дисплей. И наконец-то достойный звук!!");
        c12.setLikes(8);
        c12.setDislikes(2);
        commentCrudService.save(c12);

        List<Comment> comments2 = new ArrayList<>();
        comments2.add(c9);
        comments2.add(c10);
        comments2.add(c11);
        comments2.add(c12);

        Question q3 = new Question();
        q3.setHeadLine("Samsung");
        q3.setMainPart("Что можете сказать о Samsung S9? Заранее спасибо за ответ!");
        q3.setTags("#SamsungS9 #Samsung ");
        q3.setComments(comments2);
        q3.setLikes(21);
        q3.setDislikes(3);
        q3.setCategory(category);
        q3.setUser(user);
        questionCrudService.save(q3);
    }
}
