package com.example.projectXX.controller;

import com.example.projectXX.model.Category;
import com.example.projectXX.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CrudService<Category> categoryCrudService;

    @GetMapping("/getAll")
    public List<Category> getCategories() {
        return this.categoryCrudService.getAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = this.categoryCrudService.findById(id);
        try {
            return new ResponseEntity<>(category, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Category> saveCategory(@RequestBody Category c) {
        Category category = this.categoryCrudService.save(c);
        try {
            return new ResponseEntity<>(category, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Category> updateCategory(@RequestBody Category c) {
        Category category = this.categoryCrudService.update(c);
        try {
            return new ResponseEntity<>(category, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable Long id) {
        try {
            this.categoryCrudService.deleteById(id);
            return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>("Not deleted", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllCategories() {
        try {
            this.categoryCrudService.deleteAll();
            return new ResponseEntity<>("All categories deleted", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>("Not deleted", HttpStatus.BAD_REQUEST);
        }
    }
}

