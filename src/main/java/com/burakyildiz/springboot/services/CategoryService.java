package com.burakyildiz.springboot.services;

import com.burakyildiz.springboot.entities.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(String id) ;

    Category save(Category category);

    void delete(String id) ;
}
