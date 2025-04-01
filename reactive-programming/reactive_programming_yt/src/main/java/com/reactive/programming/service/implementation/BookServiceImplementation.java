package com.reactive.programming.service.implementation;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactive.programming.entity.Book;
import com.reactive.programming.repository.BookRepository;
import com.reactive.programming.service.BookService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookServiceImplementation implements BookService {
	@Autowired
	private BookRepository bookRepository;

	@Override
	public Mono<Book> create(Book book) {
		Mono<Book> createBook = bookRepository.save(book);
		return createBook;
	}

	@Override
	public Flux<Book> getAll() {
		return bookRepository.findAll().delayElements(Duration.ofSeconds(2)).log().map(book -> {
			book.setBookName(book.getBookName().toUpperCase());
			return book;
		});
	}

	@Override
	public Mono<Book> get(int bookId) {
		Mono<Book> item = bookRepository.findById(bookId);
		return item;
	}

	@Override
	public Mono<Book> updateBook(Book book, int bookId) {
		Mono<Book> oldBook = bookRepository.findById(bookId);
		return oldBook.flatMap(book1 -> {
			book1.setBookName(book.getBookName());
			book1.setAuthorName(book.getAuthorName());
			book1.setPublisher(book.getPublisher());
			book1.setDescription(book.getDescription());
			return bookRepository.save(book1);
		});
	}

	@Override
	public Mono<Void> deleteBook(int bookId) {
		return bookRepository.findById(bookId).flatMap(book -> bookRepository.delete(book));
	}

	@Override
	public Flux<Book> searchBook(String query) {
		return null;
	}

	@Override
	public Flux<Book> searchBooks(String title) {
		return this.bookRepository.searchBookByTitle("%" + title + "%");
	}
}
