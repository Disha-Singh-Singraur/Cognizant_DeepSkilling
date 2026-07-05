package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Exercise 1, 2, 5, 6, 7: BookService Class
 * Represents the service layer that depends on BookRepository.
 */
@Service
public class BookService {

    private BookRepository bookRepository;

    // Default Constructor (Exercise 1/5/7)
    public BookService() {
        System.out.println("[BookService] Default constructor called.");
    }

    // Constructor Injection (Exercise 7)
    public BookService(BookRepository bookRepository) {
        System.out.println("[BookService] Constructor with BookRepository parameter called (Constructor Injection).");
        this.bookRepository = bookRepository;
    }

    // Setter Injection (Exercise 2, 5, 7)
    // Annotated with @Autowired so that annotation-based config handles it automatically (Exercise 6)
    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("[BookService] setBookRepository setter called (Setter Injection).");
        this.bookRepository = bookRepository;
    }

    public void listBooks() {
        System.out.println("[BookService] Listing books...");
        if (bookRepository != null) {
            bookRepository.getBooks();
        } else {
            System.out.println("[BookService] Error: BookRepository is null! Injection failed.");
        }
    }

    public void addBook(String title) {
        System.out.println("[BookService] Adding book: " + title);
        if (bookRepository != null) {
            bookRepository.saveBook(title);
        } else {
            System.out.println("[BookService] Error: BookRepository is null! Injection failed.");
        }
    }
}
