package com.bookstore.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bookstore.domain.Book;


@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@RequestMapping(value="/booklist", method=RequestMethod.GET)
    public String booklist(Model model) {
		Iterable<Book> books = repository.findAll();
		model.addAttribute("booklist", books);
        return "booklist";
    }
	
	@RequestMapping(value="/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) repository.findAll();
	}
	
	@RequestMapping(value="/addbook")
    public String addBook(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		model.addAttribute("categories", categoryRepository.findAll());
        return "addbook";
    }
	
	@RequestMapping(value="/savebook", method=RequestMethod.POST)
    public String saveBook(Book book) {
		repository.save(book);
        return "redirect:booklist";
    }
	
	@RequestMapping(value="/book/{id}", method = RequestMethod.GET)
	public @ResponseBody Book findBookRest(@PathVariable("id") Long bookId) {
		return repository.findById(bookId).get();
	}
	
	@RequestMapping(value="/deletebook/{id}", method=RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long id, Model model) {
		repository.deleteById(id);
        return "redirect:../booklist";
    }
}