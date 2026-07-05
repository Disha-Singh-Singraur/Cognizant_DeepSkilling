package com.library.repository;

import com.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Exercise 9: BookRepository Interface
 * Leverages Spring Data JPA to provide built-in CRUD operations.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Custom query methods can be defined here if needed, 
    // but JpaRepository provides all basic CRUD operations by default.
}
