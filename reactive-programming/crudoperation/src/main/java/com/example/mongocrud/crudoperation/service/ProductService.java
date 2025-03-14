package com.example.mongocrud.crudoperation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import com.example.mongocrud.crudoperation.dto.ProductDTO;
import com.example.mongocrud.crudoperation.repository.ProductRepository;
import com.example.mongocrud.crudoperation.utils.AppUtils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    public Flux<ProductDTO> getProducts() {
        return productRepository.findAll().map(AppUtils::entityToDto);
    }

    public Mono<ProductDTO> getProduct(String id) {
        return productRepository.findById(id).map(AppUtils::entityToDto);
    }

    public Flux<ProductDTO> getProductInRange(double min, double max) {
        return productRepository.findByPriceBetween(Range.closed(min, max));
    }

    public Mono<ProductDTO> saveProduct(Mono<ProductDTO> productDTOMono) {
        return productDTOMono.map(AppUtils::dtoToEntity)
                .flatMap(productRepository::insert)
                .map(AppUtils::entityToDto);
    }

    public Mono<ProductDTO> updateProduct(Mono<ProductDTO> productDTOMono, String id) {
        return productRepository.findById(id).flatMap(p -> productDTOMono.map(AppUtils::dtoToEntity)
                .doOnNext(e -> e.setId(id)))
                .flatMap(productRepository::save)
                .map(AppUtils::entityToDto);
    }

    public Mono<Void> deleteProduct(String id) {
        return productRepository.deleteById(id);
    }
}
