package com.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.bookstore.domain.Book;
import com.bookstore.domain.Category;
import com.bookstore.web.BookRepository;
import com.bookstore.web.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CategoryRepository categoryrepository, BookRepository repository) {return (args) -> {
		categoryrepository.save(new Category("Sci-Fi"));
		categoryrepository.save(new Category("Thriller"));
		categoryrepository.save(new Category("Fantasy"));
		categoryrepository.save(new Category("Satire"));
		repository.save(new Book("1984"
				, "George Orwell"
				, "1984"
				, "1234"
				, 49.90
				, categoryrepository.findByName("Satire").get(0)));
		repository.save(new Book("Lord of the Rings"
				, "J.R.R. Tolkien"
				, "1953"
				, "1298"
				, 69.90
				, categoryrepository.findByName("Fantasy").get(0)));
		};
	}
}
