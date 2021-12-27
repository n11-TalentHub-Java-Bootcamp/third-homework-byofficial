package com.burakyildiz.springboot.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Document("product")
public class Product {
    @Id
    private Long id;
    private String productName;
    private BigDecimal price;
    private Date createdAt;
    private String categoryId;

    public Product() {
    }

    public Product(Long id, String productName, BigDecimal price, Date createdAt, String categoryId) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.createdAt = createdAt;
        this.categoryId = categoryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
