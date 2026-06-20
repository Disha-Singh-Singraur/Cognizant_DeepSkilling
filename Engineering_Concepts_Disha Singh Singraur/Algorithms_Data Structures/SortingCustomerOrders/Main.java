import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Order[] ordersForBubble = {
            new Order("O001", "Alice", 250.50),
            new Order("O002", "Bob", 120.00),
            new Order("O003", "Charlie", 450.75),
            new Order("O004", "David", 80.20),
            new Order("O005", "Emma", 310.00)
        };

        Order[] ordersForQuick = Arrays.copyOf(ordersForBubble, ordersForBubble.length);

        System.out.println("--- Original Orders ---");
        printOrders(ordersForBubble);

        System.out.println("\n--- Bubble Sort Demonstration ---");
        SortingAlgorithms.bubbleSort(ordersForBubble);
        printOrders(ordersForBubble);

        System.out.println("\n--- Quick Sort Demonstration ---");
        SortingAlgorithms.quickSort(ordersForQuick, 0, ordersForQuick.length - 1);
        printOrders(ordersForQuick);
    }

    private static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
