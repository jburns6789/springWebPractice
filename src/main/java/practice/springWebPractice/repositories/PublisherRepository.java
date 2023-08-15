package practice.springWebPractice.repositories;

import org.springframework.data.repository.CrudRepository;
import practice.springWebPractice.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
