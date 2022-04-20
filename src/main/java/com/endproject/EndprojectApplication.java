package com.endproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.endproject.domain.Videogame;
import com.endproject.domain.Genre;
import com.endproject.web.VideogameRepository;
import com.endproject.web.GenreRepository;

@SpringBootApplication
public class EndprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EndprojectApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(GenreRepository genrerepository, VideogameRepository videogamerepository) {return (args) -> {
		genrerepository.save(new Genre("FPS"));
		genrerepository.save(new Genre("MMORPG"));
		genrerepository.save(new Genre("RPG"));
		genrerepository.save(new Genre("RTS"));
		genrerepository.save(new Genre("TPS"));
		genrerepository.save(new Genre("Sandbox"));
		genrerepository.save(new Genre("MOBA"));
		genrerepository.save(new Genre("Horror"));
		videogamerepository.save(new Videogame("Guild Wars 2"
				, "Arenanet"
				, "NCSoft"
				, "2012"
				, 49.90
				, genrerepository.findByName("MMORPG").get(0)));
		videogamerepository.save(new Videogame("Warframe"
				, "Digital Extremes"
				, "Digital Extremes"
				, "2013"
				, 69.90
				, genrerepository.findByName("TPS").get(0)));
		};
	}
}
