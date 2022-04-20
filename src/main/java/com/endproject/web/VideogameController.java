package com.endproject.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.endproject.domain.Videogame;


@Controller
public class VideogameController {
	
	@Autowired
	private VideogameRepository videogamerepository;
	
	@Autowired
	private GenreRepository genreRepository;

	@RequestMapping(value="/videogamelist", method=RequestMethod.GET)
    public String booklist(Model model) {
		Iterable<Videogame> videogames = videogamerepository.findAll();
		model.addAttribute("videogamelist", videogames);
        return "videogamelist";
    }
	
	@RequestMapping(value="/addvideogame")
    public String addBook(Model model) {
		Videogame videogame = new Videogame();
		model.addAttribute("videogame", videogame);
		model.addAttribute("genres", genreRepository.findAll());
        return "addvideogame";
    }
	
	@RequestMapping(value="/savevideogame", method=RequestMethod.POST)
    public String saveVideogame(Videogame videogame) {
		videogamerepository.save(videogame);
        return "redirect:videogamelist";
    }
	
	@RequestMapping(value="/deletevideogame/{id}", method=RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long id, Model model) {
		videogamerepository.deleteById(id);
        return "redirect:../videogamelist";
    }
	
	//REST
	@RequestMapping(value="/videogame/{id}", method = RequestMethod.GET)
	public @ResponseBody Videogame findVideogameRest(@PathVariable("id") Long videogameId) {
		return videogamerepository.findById(videogameId).get();
	}
	
	//REST
	@RequestMapping(value="/videogames", method = RequestMethod.GET)
	public @ResponseBody List<Videogame> videogameListRest() {
		return (List<Videogame>) videogamerepository.findAll();
	}
}