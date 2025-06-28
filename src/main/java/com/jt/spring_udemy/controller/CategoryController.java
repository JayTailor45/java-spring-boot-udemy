package com.jt.spring_udemy.controller;

import com.jt.spring_udemy.model.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
