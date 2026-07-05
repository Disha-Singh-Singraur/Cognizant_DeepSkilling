package com.library;

import com.library.model.Book;
import com.library.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Exercise 9: LibraryManagementApplication Main Class
 * Initializes the Spring Boot application and inserts test data.
 */
@SpringBootApplication
public class LibraryManagementApplication {

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("     STARTING SPRING BOOT APPLICATION (Lab)      ");
        System.out.println("=================================================");
        SpringApplication.run(LibraryManagementApplication.class, args);
    }

    // Populate database with dummy data upon startup
    @Bean
    public CommandLineRunner loadData(BookRepository repository) {
        return (args) -> {
            System.out.println("\n[CommandLineRunner] Seeding initial book database...");
            repository.save(new Book("Spring in Action", "Craig Walls", "9781617294945"));
            repository.save(new Book("Effective Java", "Joshua Bloch", "9780134685991"));
            repository.save(new Book("Clean Architecture", "Robert C. Martin", "9780134494166"));
            System.out.println("[CommandLineRunner] Database seeding completed successfully!\n");
        };
    }
}
