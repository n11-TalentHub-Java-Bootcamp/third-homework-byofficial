package com.burakyildiz.springboot.repositories;

import com.burakyildiz.springboot.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
