package com.burakyildiz.springboot.services;

import com.burakyildiz.springboot.entities.Category;
import com.burakyildiz.springboot.services.entityService.CategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryEntityService categoryEntityService;

    public List<Category> findAll() {
        return categoryEntityService.findAll();
    }

    public Category findById(String id) {
        return categoryEntityService.findById(id);
    }

    public Category save(Category category) {
        return categoryEntityService.save(category);
    }

    public void delete(String id) {
        categoryEntityService.deleteById(id);
    }
}
