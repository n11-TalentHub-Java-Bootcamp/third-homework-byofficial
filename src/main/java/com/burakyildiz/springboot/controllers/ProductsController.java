package com.burakyildiz.springboot.controllers;

import com.burakyildiz.springboot.dto.ProductDetailDto;
import com.burakyildiz.springboot.entities.Product;
import com.burakyildiz.springboot.exceptions.ProductNotFoundException;
import com.burakyildiz.springboot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public List<Product> findAll() {
        List<Product> productList = productService.findAll();

        //Sistemde hiç ürün yoksa
        if (productList.size() == 0) {
            throw new ProductNotFoundException("There are no product!");
        }
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable String id) {
        return productService.findById(id);
    }

    @GetMapping("/detail/{id}")
    public ProductDetailDto findProductDetailDtoById(@PathVariable String id){
        return productService.findProductDetailDtoById(id);
    }

    @GetMapping("categories/{categoryId}")
    public List<ProductDetailDto> findAllProductByCategoryId(@PathVariable String categoryId){
        return productService.findAllProductByCategoryId(categoryId);
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody Product product) {

        product = productService.save(product);

        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        productService.delete(id);
    }
}
