package monitora.author.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import monitora.author.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{

}
