package com.burakyildiz.springboot.services;

import com.burakyildiz.springboot.entities.ProductReview;

import java.util.List;

public interface ProductReviewService {

    List<ProductReview> findAll();

    ProductReview findById(String id);

    ProductReview save(ProductReview productReview);

    void delete(String id);
}
