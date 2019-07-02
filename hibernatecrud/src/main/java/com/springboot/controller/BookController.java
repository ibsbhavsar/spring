package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.model.Book;
import com.springboot.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping(path = "/showbooklist")
	public ModelAndView getBookList() {
		ModelAndView modelAndView = new ModelAndView("managebook");
		List<Book> booklist = bookService.getBookList();
		modelAndView.addObject("booklist", booklist);
		return modelAndView;
	}

	@GetMapping(path = "/addbook/")
	public ModelAndView addBook() {
		ModelAndView modelAndView = new ModelAndView();
		Book book = new Book();
		modelAndView.addObject("addBook", book);
		modelAndView.setViewName("addbook");
		return modelAndView;
	}

	@PostMapping(path = "/savebook")
	public ModelAndView saveBook(@ModelAttribute("addBook") Book book) {
		bookService.save(book);
		return new ModelAndView("redirect:/showbooklist");
	}

	@GetMapping(path = "/deletebook/{id}")
	public ModelAndView deleteBook(@PathVariable("id") int id) {
		ModelAndView modelAndView = new ModelAndView("managebook");
		bookService.delete(id);
		modelAndView.addObject("booklist", bookService.getBookList());
		return modelAndView;
	}

	@GetMapping(path = "/updatebook/{id}")
	public ModelAndView editbook(@PathVariable("id") int id) {
		ModelAndView modelAndView = new ModelAndView();
		Book book = bookService.getBook(id);
		modelAndView.addObject("addBook", book);
		modelAndView.setViewName("addbook");
		modelAndView.addObject("book", book);
		return modelAndView;
	}

}
