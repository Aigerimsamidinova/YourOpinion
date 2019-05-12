package com.example.projectXX.controller;

import com.example.projectXX.model.Question;
import com.example.projectXX.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private CrudService<Question> questionCrudService;

    @GetMapping("/getAll")
    public List<Question> getAll() {
        return this.questionCrudService.getAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Question> getById(@PathVariable Long id) {
        Question question = this.questionCrudService.findById(id);
        try {
            return new ResponseEntity<>(question, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Question> saveQuestion(@RequestBody Question q) {
        Question question = this.questionCrudService.save(q);
        try {
            return new ResponseEntity<>(question, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question q) {
        Question question = this.questionCrudService.update(q);
        try {
            return new ResponseEntity<>(question, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteQuestonById(@PathVariable Long id) {
        try {
            this.questionCrudService.deleteById(id);
            return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>("Not deleted", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllQuestions() {
        try {
            this.questionCrudService.deleteAll();
            return new ResponseEntity<>("All questions deleted", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>("Not deleted", HttpStatus.BAD_REQUEST);
        }
    }
}
