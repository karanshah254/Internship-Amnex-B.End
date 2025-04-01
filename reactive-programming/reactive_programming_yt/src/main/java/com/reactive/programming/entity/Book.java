package com.reactive.programming.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("book_reactive")
public class Book {
	@Id
	@Column("book_id")
	private int bookId;

	private String bookName;

	@Column("book_desc")
	private String description;

	private String publisher;

	private String authorName;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Book(int bookId, String bookName, String description, String publisher, String authorName) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.description = description;
		this.publisher = publisher;
		this.authorName = authorName;
	}

	public Book() {

	}

}
