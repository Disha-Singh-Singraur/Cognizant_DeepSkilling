public class Main {
    public static void main(String[] args) {
        System.out.println("--- MVC Pattern Test ---");

        // Fetch student record from database/simulation
        Student model = retrieveStudentFromDatabase();

        // Create a view to write student details on console
        StudentView view = new StudentView();

        // Create Controller
        StudentController controller = new StudentController(model, view);

        // Display initial details
        System.out.println("Initial State:");
        controller.updateView();

        // Update student name and grade through controller
        System.out.println("\n[Updating student record: Changing name to Jane Smith, Grade to A+]");
        controller.setStudentName("Jane Smith");
        controller.setStudentGrade("A+");

        // Display updated details
        System.out.println("Updated State:");
        controller.updateView();
    }

    private static Student retrieveStudentFromDatabase() {
        return new Student("S101", "John Doe", "A");
    }
}
