package com.library.controller;

import com.library.model.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Exercise 9: BookController REST Controller
 * Handles incoming HTTP requests for managing books via API.
 */
@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    // GET /api/books - Retrieve all books
    @GetMapping
    public List<Book> getAllBooks() {
        System.out.println("[BookController] GET request: Fetching all books.");
        return bookRepository.findAll();
    }

    // GET /api/books/{id} - Retrieve a specific book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        System.out.println("[BookController] GET request: Fetching book with ID: " + id);
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            return new ResponseEntity<>(book.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST /api/books - Create a new book record
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        System.out.println("[BookController] POST request: Creating book: " + book.getTitle());
        Book savedBook = bookRepository.save(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    // PUT /api/books/{id} - Update an existing book record
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        System.out.println("[BookController] PUT request: Updating book with ID: " + id);
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {
            Book bookToUpdate = optionalBook.get();
            bookToUpdate.setTitle(bookDetails.getTitle());
            bookToUpdate.setAuthor(bookDetails.getAuthor());
            bookToUpdate.setIsbn(bookDetails.getIsbn());
            Book updatedBook = bookRepository.save(bookToUpdate);
            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE /api/books/{id} - Delete a book record by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable Long id) {
        System.out.println("[BookController] DELETE request: Deleting book with ID: " + id);
        try {
            bookRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
