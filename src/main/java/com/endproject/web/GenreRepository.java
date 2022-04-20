package com.endproject.web;

import org.springframework.data.repository.CrudRepository;

import com.endproject.domain.Genre;

import java.util.List;

public interface GenreRepository extends CrudRepository<Genre, Long> {
	List<Genre> findByName(String name);
	Iterable<Genre> findAll();
}

