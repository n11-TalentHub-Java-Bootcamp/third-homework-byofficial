package com.burakyildiz.springboot.repositories;

import com.burakyildiz.springboot.entities.ProductReview;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReviewRepository extends MongoRepository<ProductReview, String> {
}
