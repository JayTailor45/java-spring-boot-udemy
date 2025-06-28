package com.jt.spring_udemy.controller;

import com.jt.spring_udemy.model.Category;
import com.jt.spring_udemy.service.CategoryService;
import org.springframework.web.bind.annotation.*;

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
    public String deleteCategory(@PathVariable long categoryId) {
        if(categoryService.deleteCategory(categoryId)) {
            return "Category deleted";
        }
        return "Category not found";
    }
}
