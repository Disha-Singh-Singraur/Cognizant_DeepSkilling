package com.library.repository;

import org.springframework.stereotype.Repository;

/**
 * Exercise 1 & Exercise 6: BookRepository Class
 * Simulates repository operations for storing and fetching book data.
 */
@Repository
public class BookRepository {

    // Simple method to simulate fetching all books
    public void getBooks() {
        System.out.println("[BookRepository] Fetching books from the database...");
        System.out.println("1. Introduction to Spring Core");
        System.out.println("2. Head First Java");
        System.out.println("3. Design Patterns");
    }

    // Simple method to simulate saving a book
    public void saveBook(String title) {
        System.out.println("[BookRepository] Saving book: '" + title + "' to database.");
    }
}
