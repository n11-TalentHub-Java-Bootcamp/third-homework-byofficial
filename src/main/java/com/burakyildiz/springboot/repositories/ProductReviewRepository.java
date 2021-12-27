package com.burakyildiz.springboot.repositories;

import com.burakyildiz.springboot.entities.ProductReview;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductReviewRepository extends MongoRepository<ProductReview, String> {
}
