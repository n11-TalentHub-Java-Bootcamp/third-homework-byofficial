package com.burakyildiz.springboot.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("product_review")
public class ProductReview {
    @Id
    private String id;
    private String review;
    private Date reviewDate;
    private String productId;
    private String userId;

    public ProductReview() {
    }

    public ProductReview(String id, String review, Date reviewDate, String productId, String userId) {
        this.id = id;
        this.review = review;
        this.reviewDate = reviewDate;
        this.productId = productId;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
