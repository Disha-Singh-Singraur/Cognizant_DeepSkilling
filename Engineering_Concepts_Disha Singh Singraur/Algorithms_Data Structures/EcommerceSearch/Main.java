import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product("P105", "Wireless Mouse", "Electronics"),
            new Product("P101", "Mechanical Keyboard", "Electronics"),
            new Product("P104", "Gaming Monitor", "Electronics"),
            new Product("P102", "USB-C Hub", "Accessories"),
            new Product("P103", "Leather Wallet", "Apparel")
        };

        System.out.println("--- Linear Search Demonstration ---");
        String targetId = "P104";
        System.out.println("Searching for product: " + targetId);
        Product resultLinear = SearchAlgorithms.linearSearch(products, targetId);
        System.out.println("Linear Search Result: " + resultLinear);

        System.out.println("\n--- Binary Search Demonstration ---");
        // Sort the array first as binary search requires sorted input
        Arrays.sort(products);
        System.out.println("Sorted products for Binary Search:");
        for (Product p : products) {
            System.out.println(p);
        }

        System.out.println("\nSearching for product: " + targetId);
        Product resultBinary = SearchAlgorithms.binarySearch(products, targetId);
        System.out.println("Binary Search Result: " + resultBinary);

        System.out.println("\nSearching for non-existent product: P999");
        Product resultNotFound = SearchAlgorithms.binarySearch(products, "P999");
        System.out.println("Result: " + resultNotFound);
    }
}
