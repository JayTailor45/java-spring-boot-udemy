package com.jt.spring_udemy.controller;

import com.jt.spring_udemy.model.Category;
import com.jt.spring_udemy.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {

    private CategoryService categoryService;
    private long nextId = 1;


    CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping
    public String createCategory(@RequestBody Category category) {
        category.setCategoryId(nextId++);
        categoryService.createCategory(category);
        return "Category created";
    }

    @DeleteMapping("{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable long categoryId) {
        try {
            return new ResponseEntity<>(categoryService.deleteCategory(categoryId), HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }
}
