public class Main {
    public static void main(String[] args) {
        System.out.println("--- Observer Pattern Test ---");

        // Subject
        StockMarket stockMarket = new StockMarket();

        // Observers
        Observer mobileApp1 = new MobileApp("User A");
        Observer mobileApp2 = new MobileApp("User B");
        Observer webDashboard = new WebApp("Admin Panel");

        // Register observers
        System.out.println("Registering Observers...");
        stockMarket.registerObserver(mobileApp1);
        stockMarket.registerObserver(mobileApp2);
        stockMarket.registerObserver(webDashboard);

        // Update Stock Price
        System.out.println("\n[Updating Stock Price: GOOG to $175.25]");
        stockMarket.setStockData("GOOG", 175.25);

        // Deregister one observer
        System.out.println("\nDeregistering Mobile App Observer (User B)...");
        stockMarket.deregisterObserver(mobileApp2);

        // Update Stock Price again
        System.out.println("\n[Updating Stock Price: GOOG to $178.50]");
        stockMarket.setStockData("GOOG", 178.50);
    }
}
