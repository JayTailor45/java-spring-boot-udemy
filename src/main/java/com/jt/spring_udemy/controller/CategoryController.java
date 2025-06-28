package com.jt.spring_udemy.controller;

import com.jt.spring_udemy.model.Category;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {

    private List<Category> categories = new ArrayList<>();

    @GetMapping
    public List<Category> getCategories() {
        return categories;
    }

    @PostMapping
    public String createCategory(@RequestBody Category category) {
        categories.add(category);
        return "Category created";
    }
}
