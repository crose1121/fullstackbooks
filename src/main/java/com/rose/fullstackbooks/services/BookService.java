package com.rose.fullstackbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rose.fullstackbooks.models.Book;
import com.rose.fullstackbooks.repositories.BookRepository;

//BookService is a class that will take parameters from the controller and use the repository to manipulate the database information

@Service
public class BookService {

	//This is dope! Takes care of dependency injection and constructor for us!
	@Autowired
	BookRepository bookRepository;
	
	
	//Service uses methods that can use the repository to talk to database
	//List<Book> returns an ordered list of all Book objects
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
	
	//creates a book
	public Book createBook(Book book) {	   //accepts a book object
		return bookRepository.save(book); //creates a book and returns the id
	}
	
	//retrieve a book by its id
    public Book findBook(Long id) {
    	// this one-liner returns a book with the given id, or null if id is not found
    	return bookRepository.findById(id).orElse(null);   	
    }
    
    // we need update and delete methods here
    public Book update(Book book) {
    	return bookRepository.save(book);
    }
    
    public void delete(Long id) {
    	bookRepository.deleteById(id);
    }
    
    
    
    
    
    
    
    
    
}