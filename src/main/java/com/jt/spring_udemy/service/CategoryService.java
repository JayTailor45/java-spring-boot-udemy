package com.jt.spring_udemy.service;

import com.jt.spring_udemy.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    void createCategory(Category category);
    boolean deleteCategory(long categoryId);
}
