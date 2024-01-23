package com.work.e_commerce.service;

import com.work.e_commerce.entity.Category;
import com.work.e_commerce.exception.ErrorException;
import com.work.e_commerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category deleteCategory(long id) {
        Category willremove = getCategoryById(id);
        categoryRepository.delete(willremove);
        return willremove;
    }

    @Override
    public Category getCategoryById(long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isEmpty()){
            categoryOptional.get();
        }
        throw new ErrorException("Category not found", HttpStatus.NOT_FOUND);
    }
}
