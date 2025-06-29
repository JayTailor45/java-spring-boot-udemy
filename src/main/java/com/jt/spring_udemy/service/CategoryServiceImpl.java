package com.jt.spring_udemy.service;

import com.jt.spring_udemy.model.Category;
import com.jt.spring_udemy.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(long categoryId) {
        try {
            categoryRepository.deleteById(categoryId);
            return "Category deleted successfully";
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        }
    }

    @Override
    public Category updateCategory(long categoryId, Category category) {
        try {
            Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
            if(optionalCategory.isPresent()){
                Category oldCategory = optionalCategory.get();
                oldCategory.setCategoryName(category.getCategoryName());
                categoryRepository.save(oldCategory);
                return oldCategory;
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        }
    }
}
