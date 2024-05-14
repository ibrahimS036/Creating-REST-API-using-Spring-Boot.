package com.api.book.practice.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Service;

import com.api.book.practice.entities.Book;

@Service
public class BookService {

	private static List<Book> list = new ArrayList<>();

	static {
		// Work as temporary database.
	    list.add(new Book(45, "java complete refrence", "ABC"));
		list.add(new Book(51, "Head first to java", "XYZ"));
		list.add(new Book(66, "Think in java", "LMN"));
	    list.add(new Book(71, "Everything about web Development", "Ubaid Khan"));
	}

	// get all books
	public List<Book> getAllBooks() {
		return list;
	}

	// getting book by their Id.
	public Book getBookById(int id) {
		Iterator<Book> iterator = list.iterator();
		while (iterator.hasNext()) {
			Book next = iterator.next();
			if (next.getId() == id) {
				return next;
			}
		}
		return null;

	}

	// adding the books
	public Book createBook(Book book) {
		list.add(book);
		return book;
	}

	// delete book By Id.
	public List<Book> deleteBook(int bid) {
		Iterator<Book> iterator = list.iterator();
		while (iterator.hasNext()) {
			Book next = iterator.next();
			if (next.getId() == bid) {
				iterator.remove();
				return getAllBooks();
			}
		}
		return null;
	}

	// update Book By Id
	public Book updateBook(Book book, int id) {
		ListIterator<Book> listIterator = list.listIterator();
		while (listIterator.hasNext()) {
			Book next = listIterator.next();
			if (next.getId() == id) {
				listIterator.set(book);
				return book;
			}
		}
		return null;

	}
	
}
