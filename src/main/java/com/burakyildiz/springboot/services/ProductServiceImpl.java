package com.burakyildiz.springboot.services;

import com.burakyildiz.springboot.dto.ProductDetailDto;
import com.burakyildiz.springboot.entities.Product;
import com.burakyildiz.springboot.mapper.ProductMapper;
import com.burakyildiz.springboot.services.entityService.ProductEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductEntityService productEntityService;

    @Override
    public List<Product> findAll() {
        return productEntityService.findAll();
    }

    @Override
    public Product findById(String id) {
        return productEntityService.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productEntityService.save(product);
    }

    @Override
    public void delete(String id) {
        productEntityService.deleteById(id);
    }

    @Override
    public List<ProductDetailDto> findAllProductByCategoryId(String categoryId) {

        List<Product> productList = productEntityService.findAllProductByCategoryId(categoryId);

        List<ProductDetailDto> productDetailDtoList = ProductMapper.INSTANCE.convertAllProductListToProductDetailDtoList(productList);

        return productDetailDtoList;
    }

    @Override
    public ProductDetailDto findProductDetailDtoById(String id) {

        Product product = productEntityService.findById(id);

        ProductDetailDto productDetailDto = ProductMapper.INSTANCE.convertProductToProductDetailDto(product);

        return productDetailDto;
    }
}
