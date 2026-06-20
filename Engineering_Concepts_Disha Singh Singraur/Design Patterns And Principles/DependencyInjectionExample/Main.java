public class Main {
    public static void main(String[] args) {
        System.out.println("--- Dependency Injection Test ---");

        // 1. Create concrete dependency implementation
        CustomerRepository repo = new CustomerRepositoryImpl();

        // 2. Inject dependency via constructor
        CustomerService service = new CustomerService(repo);

        // 3. Use the service
        String customer1 = service.getCustomerName("C001");
        System.out.println("Customer C001 name: " + customer1);

        String customer2 = service.getCustomerName("C002");
        System.out.println("Customer C002 name: " + customer2);

        String customerNotFound = service.getCustomerName("C999");
        System.out.println("Customer C999 name: " + customerNotFound);
    }
}
