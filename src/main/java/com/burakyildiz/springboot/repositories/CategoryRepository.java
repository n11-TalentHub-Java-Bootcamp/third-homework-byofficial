package com.burakyildiz.springboot.repositories;

import com.burakyildiz.springboot.entities.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
}
