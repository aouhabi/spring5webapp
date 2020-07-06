package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Books;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface BookRepositories extends CrudRepository<Books,Long> {
}
