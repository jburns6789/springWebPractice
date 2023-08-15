package practice.springWebPractice.repositories;

import org.springframework.data.repository.CrudRepository;
import practice.springWebPractice.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>
//Need to define the entity and the generic type used when mapping
{


}
