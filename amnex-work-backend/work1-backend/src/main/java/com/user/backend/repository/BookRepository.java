package com.user.backend.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
// import org.springframework.stereotype.Repository;
// import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.user.backend.entity.Book;

import reactor.core.publisher.Flux;
 
public interface BookRepository extends ReactiveCrudRepository<Book, Long> {
    // Custom query to find books by author
    Flux<Book> findByAuthor(String author);
}
