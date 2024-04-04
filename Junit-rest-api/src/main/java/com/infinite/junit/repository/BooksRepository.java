package com.infinite.junit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infinite.junit.model.Book;

public interface BooksRepository extends JpaRepository<Book, Long>{

}
