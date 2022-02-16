package com.rose.fullstackbooks.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rose.fullstackbooks.models.Book;
import com.rose.fullstackbooks.services.BookService;

//the controller passes information to this API, which then uses BookService (which has BookRepository---> which has full CRUD) to create, read, update, and delete.

@RestController
public class BooksApi {
	private final BookService bookService; //create an instance of our service
	
	//inject our service into the constructor
	public BooksApi(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/api/books")
	public List<Book> index() {
		return bookService.allBooks();
	}
	
	//create a book
	@PostMapping("/api/books")
	public Book create(
			
			//@RequestParam takes info from the form and stores it in variables
			
			@RequestParam(value="title") String title,
			@RequestParam(value="description") String description,
			@RequestParam(value="language") String language,
			@RequestParam(value="pages") Integer numOfPages) {
		
		//now we need to create an instance of Book with the info from the form
		Book newBook = new Book(title,description,language,numOfPages);
		return bookService.createBook(newBook);
	}
	
	//@PathVariable lets us enter an id number as a parameter in the url so we can use it to display a book with that id
	
	@GetMapping("/api/books/{id}")
	public Book show(@PathVariable("id") Long id) {
		return bookService.findBook(id); //this returns a Book object by id
		
	}	
}














