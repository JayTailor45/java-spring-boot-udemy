package com.jt.spring_udemy.controller;

import com.jt.spring_udemy.model.Category;
import com.jt.spring_udemy.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {

    private CategoryService categoryService;


    CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping
    public String createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
        return "Category created";
    }
}
