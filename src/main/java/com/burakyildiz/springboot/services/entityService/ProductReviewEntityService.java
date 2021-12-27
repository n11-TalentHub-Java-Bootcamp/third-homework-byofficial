package com.burakyildiz.springboot.services.entityService;

import com.burakyildiz.springboot.entities.ProductReview;
import com.burakyildiz.springboot.repositories.ProductReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductReviewEntityService {
    @Autowired
    private ProductReviewRepository productReviewRepository;

    public List<ProductReview> findAll(){
        return productReviewRepository.findAll();
    }

    public ProductReview findById(String id){

        Optional<ProductReview> optional = productReviewRepository.findById(id);

        ProductReview productReview = null;
        if (optional.isPresent()){
            productReview = optional.get();
        }

        return productReview;
    }

    public void deleteById(String id){
        productReviewRepository.deleteById(id);
    }

    public ProductReview save(ProductReview productReview){
        return productReviewRepository.save(productReview);
    }
}
