import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Book[] books = {
            new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book("B002", "To Kill a Mockingbird", "Harper Lee"),
            new Book("B003", "1984", "George Orwell"),
            new Book("B004", "Pride and Prejudice", "Jane Austen"),
            new Book("B005", "Moby Dick", "Herman Melville")
        };

        System.out.println("--- Linear Search Demonstration ---");
        String targetTitle = "1984";
        System.out.println("Searching for: \"" + targetTitle + "\"");
        Book foundLinear = LibrarySearch.linearSearchByTitle(books, targetTitle);
        System.out.println("Result: " + foundLinear);

        System.out.println("\n--- Binary Search Demonstration ---");
        // Sort by title first
        Arrays.sort(books);
        System.out.println("Sorted books by Title:");
        for (Book b : books) {
            System.out.println(b);
        }

        System.out.println("\nSearching for: \"" + targetTitle + "\"");
        Book foundBinary = LibrarySearch.binarySearchByTitle(books, targetTitle);
        System.out.println("Result: " + foundBinary);

        System.out.println("\nSearching for non-existent: \"The Hobbit\"");
        Book notFound = LibrarySearch.binarySearchByTitle(books, "The Hobbit");
        System.out.println("Result: " + notFound);
    }
}
