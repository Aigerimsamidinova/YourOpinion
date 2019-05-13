package com.example.projectXX.controller;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.projectXX.model.Comment;
import com.example.projectXX.model.Question;
import com.example.projectXX.model.User;
import com.example.projectXX.model.User;
import com.example.projectXX.reposiroty.QuestionRep;
import com.example.projectXX.service.CrudService;
import com.example.projectXX.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private CrudService<User> userCrudService;

    @Autowired
    private QuestionRep questionRep;

    @Autowired
    private UserService userService;

    @PostMapping("/addQuestion/{userId}/{categoryId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Question> postQuestion(@PathVariable Long userId,
                                                 @PathVariable Long categoryId,
                                                 @RequestBody Question question) {
        try {
            return new ResponseEntity<>(userService.addQuestion(userId, categoryId, question), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/addCommentToQuestion/{userId}/{questionId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Question> commentToQuestion(@PathVariable Long userId,
                                                      @PathVariable Long questionId,
                                                      @RequestBody Comment comment) {
        try {
            return new ResponseEntity<>(userService.addCommentToQuestion(userId, questionId, comment), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/putMarkOnTheQuestion/{userId}/{questionId}/{mark}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Question> postMarkToQuestion(@PathVariable Long userId,
                                                       @PathVariable Long questionId,
                                                       @PathVariable Character mark) {
        try {
            return new ResponseEntity<>(userService.putMarkOnTheQuestion(userId, questionId, mark), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/putMarkOnTheComment/{userId}/{questionId}/{commentId}/{mark}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Comment> postMarkToComment(@PathVariable Long userId,
                                                     @PathVariable Long questionId,
                                                     @PathVariable Long commentId,
                                                     @PathVariable Character mark) {
        try {
            return new ResponseEntity<>(userService.putMarkOnTheComment(userId, questionId, commentId, mark), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    public List<User> getUsers() {
        return this.userCrudService.getAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = this.userCrudService.findById(id);
        try {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> saveUser(@RequestBody User c) {
        User user = this.userCrudService.save(c);
        try {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User c) {
        User user = this.userCrudService.update(c);
        try {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        try {
            this.userCrudService.deleteById(id);
            return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>("Not deleted", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllUsers() {
        try {
            this.userCrudService.deleteAll();
            return new ResponseEntity<>("All users deleted", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>("Not deleted", HttpStatus.BAD_REQUEST);
        }
    }
}

