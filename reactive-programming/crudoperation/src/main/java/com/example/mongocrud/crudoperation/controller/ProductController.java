package com.example.mongocrud.crudoperation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.mongocrud.crudoperation.dto.ProductDTO;
import com.example.mongocrud.crudoperation.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Flux<ProductDTO> fetchProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Mono<ProductDTO> fetchProduct(@PathVariable String id) {
        return productService.getProduct(id);
    }

    @GetMapping("range")
    public Flux<ProductDTO> fetchProductBetweenRange(@RequestParam("min") double min, @RequestParam("max") double max) {
        return productService.getProductInRange(min, max);
    }

    @PostMapping("save")
    public Mono<ProductDTO> saveProduct(@RequestBody Mono<ProductDTO> productDto) {
        return productService.saveProduct(productDto);
    }

    @PutMapping("update/{id}")
    public Mono<ProductDTO> updateProduct(@RequestBody Mono<ProductDTO> productDto, @PathVariable String id) {
        return productService.updateProduct(productDto, id);
    }

    @DeleteMapping("delete/{id}")
    public Mono<Void> deleteProduct(@PathVariable String id) {
        return productService.deleteProduct(id);
    }
}
