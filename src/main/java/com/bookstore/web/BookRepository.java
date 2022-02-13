package com.bookstore.web;


import org.springframework.data.repository.CrudRepository;

import com.bookstore.domain.Book;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findByAuthor(String author);
	Iterable<Book> findAll();
}
