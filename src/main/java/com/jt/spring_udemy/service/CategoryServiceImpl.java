package com.jt.spring_udemy.service;

import com.jt.spring_udemy.exceptions.APIException;
import com.jt.spring_udemy.exceptions.ResourceNotFoundException;
import com.jt.spring_udemy.model.Category;
import com.jt.spring_udemy.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        Category oldCategory = categoryRepository.findByCategoryName(category.getCategoryName());
        if (oldCategory != null) {
            throw new APIException(String.format("Category with the name %s already exists", category.getCategoryName()));
        }
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
        categoryRepository.delete(category);
        return "Category deleted successfully";
    }

    @Override
    public Category updateCategory(long categoryId, Category category) {
        Category oldCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        oldCategory.setCategoryName(category.getCategoryName());
        categoryRepository.save(oldCategory);
        return oldCategory;
    }
}
