package com.rose.fullstackbooks.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rose.fullstackbooks.models.Book;

//book repository is an interface that inherits full CRUD from another interface named CrudRepository. The repository directly manipulates the database information. 

//Remember to annotate with @Repository

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findAll();
	List<Book> findByDescriptionContaining(String search);
}
