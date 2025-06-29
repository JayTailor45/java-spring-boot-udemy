package com.jt.spring_udemy.service;

import com.jt.spring_udemy.payload.CategoryDTO;
import com.jt.spring_udemy.payload.CategoryResponse;

public interface CategoryService {
    CategoryResponse getCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO deleteCategory(long categoryId);
    CategoryDTO updateCategory(long categoryId, CategoryDTO categoryDTO);
}
