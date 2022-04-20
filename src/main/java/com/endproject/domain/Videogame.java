package com.endproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Videogame {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String title;
	private String developer;
	private String publisher;
	private String year;
	private Double price;	
	
	@ManyToOne
	@JoinColumn(name = "genreId")
	private Genre genre;

	public Videogame() {
	}

	public Videogame(String title, String developer, String publisher, String year, Double price, Genre genre) {
		this.title = title;
		this.developer = developer;
		this.publisher = developer;
		this.year = year;
		this.price = price;
		this.genre = genre;
	}	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	 public String toString() {
	 return "Videogame id=" + id +
			" ,title=" + this.title + 
			" ,developer=" + this.developer +
			" ,publisher=" + this.publisher +
			" ,year=" + this.year +
	 		" ,price=" + this.price +
	 		" ,genre=" + this.genre;
	 }
}
