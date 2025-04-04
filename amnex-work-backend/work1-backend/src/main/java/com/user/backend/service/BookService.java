package com.user.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import com.user.backend.entity.Book;
import com.user.backend.repository.BookRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Flux<Book> getAllBooks() {
        return bookRepository.findAll(); // Fetch all books
    }

    public Mono<Book> getBookById(Long id) {
        return bookRepository.findById(id); // Fetch a single book by ID
    }
}
