package malik.punit.spring5udemy.repositories;

import malik.punit.spring5udemy.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
