package malik.punit.spring5udemy.repositories;

import malik.punit.spring5udemy.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
