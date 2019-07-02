package com.springboot.service;

import java.util.List;

import com.springboot.model.Book;

public interface BookService {

	public void save(Book book);

	public void delete(int id);

	public Book getBook(int id);

	List<Book> getBookList();
}
