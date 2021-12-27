package com.burakyildiz.springboot.services.entityService;

import com.burakyildiz.springboot.entities.Product;
import com.burakyildiz.springboot.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductEntityService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(String id){

        Optional<Product> optional = productRepository.findById(id);

        Product product = null;
        if (optional.isPresent()){
            product = optional.get();
        }

        return product;
    }

    public void deleteById(String id){
        productRepository.deleteById(id);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }
}