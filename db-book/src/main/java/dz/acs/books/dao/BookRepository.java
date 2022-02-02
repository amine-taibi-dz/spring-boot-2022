package dz.acs.books.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dz.acs.books.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book,Long>{

}
