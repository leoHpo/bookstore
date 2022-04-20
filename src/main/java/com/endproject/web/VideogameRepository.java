package com.endproject.web;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.endproject.domain.Videogame;

import java.util.List;

@RepositoryRestResource
public interface VideogameRepository extends CrudRepository<Videogame, Long> {
	List<Videogame> findByDeveloper(@Param("developer") String developer);
	Iterable<Videogame> findAll();
}
