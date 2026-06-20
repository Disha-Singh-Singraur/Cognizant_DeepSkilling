public class Main {
    public static void main(String[] args) {
        EmployeeManager em = new EmployeeManager(5);

        System.out.println("--- Adding Employees ---");
        em.addEmployee(new Employee("E001", "John Doe", "Software Engineer", 75000));
        em.addEmployee(new Employee("E002", "Jane Smith", "Project Manager", 85000));
        em.addEmployee(new Employee("E003", "Robert Johnson", "QA Analyst", 60000));
        em.traverseEmployees();

        System.out.println("\n--- Searching Employee E002 ---");
        Employee found = em.searchEmployee("E002");
        System.out.println("Found: " + found);

        System.out.println("\n--- Deleting Employee E001 ---");
        em.deleteEmployee("E001");
        em.traverseEmployees();

        System.out.println("\n--- Testing Edge Case (Deleting Non-existent) ---");
        em.deleteEmployee("E999");

        System.out.println("\n--- Testing Full Capacity ---");
        em.addEmployee(new Employee("E004", "Alice Brown", "UI/UX Designer", 70000));
        em.addEmployee(new Employee("E005", "Charlie Green", "HR Specialist", 65000));
        em.addEmployee(new Employee("E006", "David Miller", "DevOps Engineer", 80000)); // Now capacity is full (5)
        em.addEmployee(new Employee("E007", "Eva Long", "Data Analyst", 72000)); // Should exceed capacity
        System.out.println("Final Employee List:");
        em.traverseEmployees();
    }
}
