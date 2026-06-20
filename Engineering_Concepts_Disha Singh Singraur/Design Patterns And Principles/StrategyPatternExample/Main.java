public class Main {
    public static void main(String[] args) {
        System.out.println("--- Strategy Pattern Test ---");

        PaymentContext context = new PaymentContext();

        // 1. Pay using Credit Card
        System.out.println("Selecting Credit Card Payment...");
        PaymentStrategy creditCard = new CreditCardPayment("John Doe", "1234567890123456", "123", "12/28");
        context.setPaymentStrategy(creditCard);
        context.executePayment(500.00);

        System.out.println();

        // 2. Pay using PayPal
        System.out.println("Selecting PayPal Payment...");
        PaymentStrategy payPal = new PayPalPayment("john.doe@example.com", "mypassword123");
        context.setPaymentStrategy(payPal);
        context.executePayment(75.50);
    }
}
