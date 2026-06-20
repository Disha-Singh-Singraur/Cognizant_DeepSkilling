public class EmployeeManager {
    private Employee[] employees;
    private int count;

    public EmployeeManager(int capacity) {
        this.employees = new Employee[capacity];
        this.count = 0;
    }

    // Add an employee
    public boolean addEmployee(Employee employee) {
        if (count >= employees.length) {
            System.out.println("Cannot add employee: Management system is at full capacity.");
            return false;
        }
        employees[count] = employee;
        count++;
        return true;
    }

    // Search for an employee by ID
    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse and display all employees
    public void traverseEmployees() {
        if (count == 0) {
            System.out.println("No employees found.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete an employee by ID
    public boolean deleteEmployee(String employeeId) {
        int indexToDelete = -1;
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete == -1) {
            System.out.println("Employee with ID " + employeeId + " not found.");
            return false;
        }

        // Shift elements to the left to close the gap
        for (int i = indexToDelete; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[count - 1] = null; // Clear reference
        count--;
        return true;
    }
}
