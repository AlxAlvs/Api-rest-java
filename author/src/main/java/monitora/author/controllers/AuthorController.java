package monitora.author.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import monitora.author.entities.Author;
import monitora.author.repositories.AuthorRepository;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	
	@Autowired
	public AuthorRepository authorRepository;
	
	@GetMapping
	public List<Author> getAll() {		
		return this.authorRepository.findAll();	
	}
	
	@GetMapping("/{id}")
	public Optional<Author> findById(@PathVariable("id") int id) {
	    return this.authorRepository.findById(id);
	}
	
	@PostMapping
	public void save(@RequestBody Author author) {
		this.authorRepository.save(author);
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	public void change(@PathVariable("id") Integer id, @RequestBody Author author) {
		author.setId(id);
		this.authorRepository.save(author);
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	public void exclude(@PathVariable("id") Integer id) {
		this.authorRepository.deleteById(id);
	}
}
