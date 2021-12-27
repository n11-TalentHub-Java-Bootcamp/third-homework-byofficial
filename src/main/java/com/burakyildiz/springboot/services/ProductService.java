package com.burakyildiz.springboot.services;

import com.burakyildiz.springboot.dto.ProductDetailDto;
import com.burakyildiz.springboot.entities.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(String id) ;

    Product save(Product product);

    void delete(String id) ;

    List<ProductDetailDto> findAllProductByCategoryId(String categoryId);

    ProductDetailDto findProductDetailDtoById(String id);
}
