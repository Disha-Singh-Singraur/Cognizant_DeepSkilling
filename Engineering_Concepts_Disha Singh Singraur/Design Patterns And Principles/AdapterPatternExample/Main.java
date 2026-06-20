public class Main {
    public static void main(String[] args) {
        System.out.println("--- Adapter Pattern Test ---");

        // 1. Test PayPal Adapter
        PayPalGateway payPalGateway = new PayPalGateway();
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPalGateway);
        payPalProcessor.processPayment(150.00);

        System.out.println();

        // 2. Test Stripe Adapter
        StripeGateway stripeGateway = new StripeGateway();
        PaymentProcessor stripeProcessor = new StripeAdapter(stripeGateway);
        stripeProcessor.processPayment(275.50);
    }
}
