package com.reactive.programming.service;

import org.springframework.stereotype.Service;

import com.reactive.programming.entity.Book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface BookService {
	public Mono<Book> create(Book book);

	public Flux<Book> getAll();

	public Mono<Book> get(int bookId);

	public Mono<Book> updateBook(Book book, int bookId);

	public Mono<Void> deleteBook(int bookId);

	public Flux<Book> searchBook(String query);
	
	public Flux<Book> searchBooks(String title);
}
