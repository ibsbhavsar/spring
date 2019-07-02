package com.springboot.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.BookDAO;
import com.springboot.model.Book;
import com.springboot.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO bookDAO;

	@Override
	public void save(Book book) {
		bookDAO.save(book);
	}

	@Override
	public void delete(int id) {
		bookDAO.delete(id);
	}

	@Override
	public Book getBook(int id) {
		return bookDAO.getBook(id);
	}

	@Override
	public List<Book> getBookList() {
		return bookDAO.getBookList();
	}

}
