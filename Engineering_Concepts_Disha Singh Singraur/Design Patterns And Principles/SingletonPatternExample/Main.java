public class Main {
    public static void main(String[] args) {
        System.out.println("--- Singleton Pattern Test ---");

        // Attempt to get instance of Logger twice
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Check if both references point to the same object
        if (logger1 == logger2) {
            System.out.println("Success: Both logger1 and logger2 point to the same instance.");
        } else {
            System.out.println("Failure: Different instances exist.");
        }

        // Use the logger
        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");
    }
}
