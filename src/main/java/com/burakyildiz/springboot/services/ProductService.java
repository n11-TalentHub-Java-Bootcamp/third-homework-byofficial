package com.burakyildiz.springboot.services;

import com.burakyildiz.springboot.entities.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(String id) ;

    Product save(Product product);

    void delete(String id) ;
}
