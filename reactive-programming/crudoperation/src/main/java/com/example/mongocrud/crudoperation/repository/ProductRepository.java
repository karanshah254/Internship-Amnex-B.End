package com.example.mongocrud.crudoperation.repository;

import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mongocrud.crudoperation.dto.ProductDTO;
import com.example.mongocrud.crudoperation.entity.Product;

import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

    Flux<ProductDTO> findByPriceBetween(Range<Double> priceRange);
}
