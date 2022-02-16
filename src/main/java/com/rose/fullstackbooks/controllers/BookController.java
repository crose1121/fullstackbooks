package com.rose.fullstackbooks.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.rose.fullstackbooks.models.Book;
import com.rose.fullstackbooks.services.BookService;

//these are our front end routes
//use @Controller to render templates to the front end

@Controller
public class BookController {
	
	@Autowired
	BookService bookService; //this takes care of our dependency injection and constructor for us in only 2 lines!
	
	
	//routes
	
	@GetMapping("/books")
	public String index(Model model) {
		System.out.println(this.bookService.allBooks()); 
		List<Book> allBooks = this.bookService.allBooks();
		model.addAttribute("allBooks",allBooks);
		
		//we need to send an empty book object to the form using empty constructor below
		model.addAttribute("book", new Book());
		return "index.jsp";
	}
	
	@GetMapping("/books/{id}") //get info about a book by id #
	public String show(@PathVariable("id") Long id, Model model) { // here we need pathvariable as well as model injection 
		Book book = bookService.findBook(id); //use the service to find the book with the id
		model.addAttribute("book", book);
		
		
		return "oneItem.jsp";
	}
	
	//For create route, @Valid and @ModelAttribute need to be together, "book" must match empty book object you passed in on line 41
	
	@PostMapping("/books/create")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
		
		if (result.hasErrors()) { //if there's a failed validation, an error will be stored in result - this is how we check
			List<Book> allBooks = bookService.allBooks();
			model.addAttribute("allBooks", allBooks);
			return "index.jsp"; // the only time we render on a post
		}
		
		//if form filled out correctly, info saved to book variable
		else {
			this.bookService.createBook(book); //use service to create it
			return "redirect:/books";
		}
	}
	
	@GetMapping("/books/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		//we have to get info about the specific book so we can pre populate the form
		Book book = bookService.findBook(id);
		model.addAttribute("book",book);
		return "edit.jsp";
	}
	
	//we need a put mapping to update db entry
	
	@PutMapping("/books/update/{id}")
	public String update(
			@PathVariable("id")Long id,
			@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) 
	{
		if (result.hasErrors()) {
			
			return "edit.jsp";
		}
		else {
			bookService.update(book);
			return "redirect:/books";
		}
		
	}
	
	@GetMapping("/books/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		bookService.delete(id);
		return "redirect:/books";
	}
	
	
	
	
}
