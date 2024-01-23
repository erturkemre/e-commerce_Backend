package com.work.e_commerce.service;

import com.work.e_commerce.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category createCategory(Category category);

    Category updateCategory(Category category);

    Category deleteCategory(long id);

    Category getCategoryById(long id);
}
