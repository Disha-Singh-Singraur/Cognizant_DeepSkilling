public class CustomerService {
    private final CustomerRepository repository;

    // Constructor Injection
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public String getCustomerName(String id) {
        String name = repository.findCustomerById(id);
        if (name != null) {
            return name;
        } else {
            return "Customer not found.";
        }
    }
}
