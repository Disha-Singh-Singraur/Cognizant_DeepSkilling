package com.library;

import com.library.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main application class to test XML Configuration, Dependency Injection, and AOP.
 * Tests Exercises 1, 2, 3, 5, 7, and 8.
 */
public class MainXML {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("   TESTING XML CONFIGURATION & DI & AOP (Lab)    ");
        System.out.println("=================================================");

        // 1. Load application context from ClassPath
        System.out.println("\n[Main] Loading applicationContext.xml...");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("[Main] Context successfully loaded!\n");

        // 2. Test Setter Injection Bean (Exercises 1, 2, 5, 7)
        System.out.println("--- Testing BookService with Setter Injection ---");
        BookService serviceSetter = (BookService) context.getBean("bookServiceSetter");
        serviceSetter.addBook("Design Patterns in Java");
        serviceSetter.listBooks();
        System.out.println("-------------------------------------------------\n");

        // 3. Test Constructor Injection Bean (Exercise 7)
        System.out.println("--- Testing BookService with Constructor Injection ---");
        BookService serviceConstructor = (BookService) context.getBean("bookServiceConstructor");
        serviceConstructor.listBooks();
        System.out.println("------------------------------------------------------\n");

        // 4. Close context
        System.out.println("[Main] Closing Spring application context...");
        context.close();
        System.out.println("[Main] Done!");
    }
}
