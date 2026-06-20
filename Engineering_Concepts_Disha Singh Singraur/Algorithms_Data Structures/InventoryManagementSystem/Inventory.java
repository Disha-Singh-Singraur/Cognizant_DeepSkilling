import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Product> products;

    public Inventory() {
        this.products = new HashMap<>();
    }

    // Add a product
    public void addProduct(Product product) {
        if (product == null) return;
        products.put(product.getProductId(), product);
    }

    // Update an existing product
    public void updateProduct(String productId, int newQuantity, double newPrice) {
        Product product = products.get(productId);
        if (product != null) {
            product.setQuantity(newQuantity);
            product.setPrice(newPrice);
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    // Delete a product
    public void deleteProduct(String productId) {
        if (products.containsKey(productId)) {
            products.remove(productId);
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    // Display all products
    public void displayInventory() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product product : products.values()) {
                System.out.println(product);
            }
        }
    }
}
