package com.example.mongocrud.crudoperation.utils;

import org.springframework.beans.BeanUtils;

import com.example.mongocrud.crudoperation.dto.ProductDTO;
import com.example.mongocrud.crudoperation.entity.Product;

public class AppUtils {
    public static ProductDTO entityToDto(Product product) {
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product, productDTO);
        return productDTO;
    }

    public static Product dtoToEntity(ProductDTO productDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        return product;
    }
}
