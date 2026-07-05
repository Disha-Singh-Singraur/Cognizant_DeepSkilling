package com.library;

import com.library.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main application class to test Annotation-based Spring Configuration.
 * Tests Exercise 6.
 */
public class MainAnnotations {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("     TESTING ANNOTATION CONFIGURATION (Lab)      ");
        System.out.println("=================================================");

        // 1. Load application context with annotations config enabled
        System.out.println("\n[Main] Loading applicationContext-annotations.xml...");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-annotations.xml");
        System.out.println("[Main] Context successfully loaded!\n");

        // 2. Retrieve BookService bean (scanned by annotation)
        // In component scanning, the bean name defaults to class name in camelCase (bookService)
        System.out.println("--- Testing BookService (Annotation Autowired) ---");
        BookService service = (BookService) context.getBean("bookService");
        service.addBook("Clean Code");
        service.listBooks();
        System.out.println("--------------------------------------------------\n");

        // 3. Close context
        System.out.println("[Main] Closing Spring application context...");
        context.close();
        System.out.println("[Main] Done!");
    }
}
