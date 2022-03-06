package com.bookstore.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookstore.domain.Book;


@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;

	@RequestMapping(value="/booklist", method=RequestMethod.GET)
    public String booklist(Model model) {
		Iterable<Book> books = repository.findAll();
		model.addAttribute("booklist", books);
        return "booklist";
    }
	
	@RequestMapping(value="/addbook")
    public String addBook(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
        return "addbook";
    }
	
	@RequestMapping(value="/savebook", method=RequestMethod.POST)
    public String saveBook(Book book) {
		System.out.println(book.toString());
		repository.save(book);
		System.out.println(book.toString());
        return "redirect:booklist";
    }
	
	@RequestMapping(value="/deletebook/{id}", method=RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long id, Model model) {
		repository.deleteById(id);
        return "redirect:../booklist";
    }
}