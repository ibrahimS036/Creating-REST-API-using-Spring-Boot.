package com.api.book.practice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.book.practice.entities.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

}
