package com.infinite.junit.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.junit.model.Book;
import com.infinite.junit.repository.BooksRepository;

import javassist.NotFoundException;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	BooksRepository bookRepository;
	
	@GetMapping("/allbooks")
	public List<Book> getAllBookssRecords(){
		return bookRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable("id") Long bookId) {
		return bookRepository.findById(bookId).get();
	}
	
	@PostMapping("/new")
	public Book addingNewBook(@RequestBody @Valid Book bookData) {
		return bookRepository.save(bookData);
	}
	
	@PutMapping("/update")
	public Book updateBookData(@RequestBody @Valid Book bookData) throws NotFoundException {
		if(bookData == null || bookData.getBookId() == null) {
			throw new NotFoundException("Book Data or Book ID must be same.");
		}
		Optional<Book> optionalBook = bookRepository.findById(bookData.getBookId());
		if(!optionalBook.isPresent()) {
			throw new NotFoundException("Book with Id "+bookData.getBookId()+" dose not exist.");
		}
		
		Book existingBookData = optionalBook.get();
		
		existingBookData.setName(bookData.getName());
		existingBookData.setSummary(bookData.getSummary());
		existingBookData.setRating(bookData.getRating());
		
		return bookRepository.save(existingBookData);
	}
	
	
	
}
