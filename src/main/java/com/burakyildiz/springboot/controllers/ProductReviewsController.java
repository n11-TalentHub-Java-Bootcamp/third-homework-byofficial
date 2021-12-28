package com.burakyildiz.springboot.controllers;

import com.burakyildiz.springboot.dto.ProductReviewDto;
import com.burakyildiz.springboot.entities.ProductReview;
import com.burakyildiz.springboot.exceptions.ProductReviewNotFoundException;
import com.burakyildiz.springboot.mapper.ProductReviewMapper;
import com.burakyildiz.springboot.services.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ProductReviewsController {
    @Autowired
    private ProductReviewService productReviewService;

    @GetMapping("")
    public List<ProductReviewDto> findAll() {
        List<ProductReview> productReviewList = productReviewService.findAll();

        //Sistemde hiç yorum yoksa
        if (productReviewList.size() == 0) {
            throw new ProductReviewNotFoundException("There are no review!");
        }

        List<ProductReviewDto> reviewDtoList = ProductReviewMapper.INSTANCE.convertAllReviewListToReviewDtoList(productReviewList);

        return reviewDtoList;
    }



    @GetMapping("/{id}")
    public ProductReview findById(@PathVariable String id) {
        return productReviewService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody ProductReview productReview) {

        productReview = productReviewService.save(productReview);

        return new ResponseEntity<>(productReview, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        productReviewService.delete(id);
    }
}
