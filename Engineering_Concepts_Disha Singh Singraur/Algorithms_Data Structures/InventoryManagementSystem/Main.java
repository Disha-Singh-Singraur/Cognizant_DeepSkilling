public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        System.out.println("--- Initializing Inventory ---");
        Product p1 = new Product("P001", "Laptop", 10, 999.99);
        Product p2 = new Product("P002", "Smartphone", 25, 499.99);
        Product p3 = new Product("P003", "Headphones", 50, 79.99);

        inventory.addProduct(p1);
        inventory.addProduct(p2);
        inventory.addProduct(p3);
        inventory.displayInventory();

        System.out.println("\n--- Updating Smartphone (P002) Quantity to 20 and Price to $479.99 ---");
        inventory.updateProduct("P002", 20, 479.99);
        inventory.displayInventory();

        System.out.println("\n--- Deleting Headphones (P003) ---");
        inventory.deleteProduct("P003");
        inventory.displayInventory();

        System.out.println("\n--- Trying to update non-existent product ---");
        inventory.updateProduct("P999", 5, 10.00);
    }
}
