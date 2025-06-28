package com.jt.spring_udemy.service;

import com.jt.spring_udemy.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private List<Category> categories = new ArrayList<>();

    @Override
    public List<Category> getCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        categories.add(category);
    }

    @Override
    public String deleteCategory(long categoryId) {
        boolean isDeleted = categories.removeIf(category -> category.getCategoryId() == categoryId);
        if(!isDeleted){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        }
        return "Category deleted successfully";
    }
}
