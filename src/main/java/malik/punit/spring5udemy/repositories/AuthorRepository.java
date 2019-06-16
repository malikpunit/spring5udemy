package malik.punit.spring5udemy.repositories;

import malik.punit.spring5udemy.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
