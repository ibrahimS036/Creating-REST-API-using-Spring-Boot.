package com.api.book.practice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.api.book.practice.entities.Book;
import com.api.book.practice.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookservice;

	// get all book handler
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> allBooks = bookservice.getAllBooks();
		if (allBooks.size() <= 0) {
			// return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			return new ResponseEntity<List<Book>>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.of(Optional.of(allBooks));
		// return new ResponseEntity<List<Book>>(allBooks, HttpStatus.NOT_FOUND);
	}
	// get book by id handler
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getSingleBook(@PathVariable("id") int id) {
		Book bookById = bookservice.getBookById(id);
		if (bookById == null) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.of(Optional.of(bookById));
	}
	// Create book handler
	@PostMapping("/books")
	public ResponseEntity<Book> createBooks(@RequestBody Book book) {
		Book book2 = this.bookservice.createBook(book);
		if (book2 == null) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		} else {
			return ResponseEntity.of(Optional.of(book2));
		}
	}
	// delete book by id handler
	@DeleteMapping("/books/{bookid}")
	public ResponseEntity<List<Book>> deleteById(@PathVariable("bookid") int bookid) {
		// System.out.println("book Id ");
		List<Book> deleteBook = this.bookservice.deleteBook(bookid);
		if (deleteBook == null) {
			return new ResponseEntity<List<Book>>(HttpStatus.NOT_FOUND);
		} else {
			return ResponseEntity.of(Optional.of(deleteBook));
		}
	}
	// update book by d handler.
	@PutMapping("/books/{uid}")
	public ResponseEntity<Book> updateBookById(@RequestBody Book book, @PathVariable("uid") int uid) {
		Book updateBook = this.bookservice.updateBook(book, uid);
		if (updateBook == null) {
			return new ResponseEntity<Book>(HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<Book>(updateBook, HttpStatus.OK);
		}
	}
}
