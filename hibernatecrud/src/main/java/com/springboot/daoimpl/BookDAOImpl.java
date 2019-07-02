package com.springboot.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.dao.BookDAO;
import com.springboot.model.Book;

@Repository
@Transactional
public class BookDAOImpl implements BookDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Book book) {
		Session session = sessionFactory.getCurrentSession();
		session.save(book);
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Book book = session.get(Book.class, id);
		session.delete(book);
	}

	@Override
	public Book getBook(int id) {
		Book book = sessionFactory.getCurrentSession().get(Book.class, id);
		return book;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Book> getBookList() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Book> list = session.createCriteria(Book.class).list();
		return list;
	}

}
