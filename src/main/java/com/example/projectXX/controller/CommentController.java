package com.example.projectXX.controller;

import com.example.projectXX.model.Comment;
import com.example.projectXX.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    private CrudService<Comment> CommentCrudService;

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Comment> saveComment(@RequestBody Comment c){
        Comment Comment = this.CommentCrudService.add(c);
        try {
            return new ResponseEntity<>(Comment, HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    public List<Comment> getCommentaries(){
        return this.CommentCrudService.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id){
        Comment Comment = this.CommentCrudService.findById(id);
        try {
            return new ResponseEntity<>(Comment, HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Comment> updteComment(@RequestBody Comment c){
        Comment Comment = this.CommentCrudService.update(c);
        try {
            return new ResponseEntity<>(Comment, HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable Long id){
        try {
            this.CommentCrudService.deleteById(id);
            return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println(e.toString());
            return new ResponseEntity<>("Not deleted", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllCommentaries(){
        try {
            this.CommentCrudService.deleteAll();
            return new ResponseEntity<>("All commentaries deleted", HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println(e.toString());
            return new ResponseEntity<>("Not deleted", HttpStatus.BAD_REQUEST);
        }
    }
}
