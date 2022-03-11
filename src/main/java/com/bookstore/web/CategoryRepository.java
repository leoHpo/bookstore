package com.bookstore.web;

import org.springframework.data.repository.CrudRepository;
import com.bookstore.domain.Category;
import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findByName(String name);
	Iterable<Category> findAll();
}

