package com.burakyildiz.springboot.mapper;

import com.burakyildiz.springboot.dto.ProductReviewDto;
import com.burakyildiz.springboot.entities.ProductReview;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductReviewMapper {
    ProductReviewMapper INSTANCE = Mappers.getMapper(ProductReviewMapper.class);


    List<ProductReviewDto> convertAllReviewListToReviewDtoList(List<ProductReview> productReviewList);
}
