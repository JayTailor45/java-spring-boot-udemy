package com.jt.spring_udemy.controller;

import com.jt.spring_udemy.model.Category;
import com.jt.spring_udemy.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {

    private CategoryService categoryService;


    CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories = categoryService.getCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createCategory(@Valid @RequestBody Category category) {
        categoryService.createCategory(category);
        return new ResponseEntity<>("Category created", HttpStatus.CREATED);
    }

    @DeleteMapping("{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable long categoryId) {
        try {
            return new ResponseEntity<>(categoryService.deleteCategory(categoryId), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

    @PutMapping("{categoryId}")
    public ResponseEntity<String> updateCategory(@PathVariable long categoryId, @RequestBody Category category) {
        try {
            categoryService.updateCategory(categoryId, category);
            return new ResponseEntity<>("Category with id " + categoryId + " updated successfully", HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }
}
