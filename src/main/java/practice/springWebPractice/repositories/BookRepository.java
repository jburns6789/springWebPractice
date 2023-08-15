package practice.springWebPractice.repositories;

import org.springframework.data.repository.CrudRepository;
import practice.springWebPractice.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>
// you want the domain value when importing the class
{

}
