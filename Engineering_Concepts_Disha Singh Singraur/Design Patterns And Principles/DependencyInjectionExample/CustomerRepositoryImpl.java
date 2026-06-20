public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(String id) {
        // Simulating data access from database
        if ("C001".equals(id)) {
            return "Alice Johnson";
        } else if ("C002".equals(id)) {
            return "Bob Thompson";
        }
        return null;
    }
}
