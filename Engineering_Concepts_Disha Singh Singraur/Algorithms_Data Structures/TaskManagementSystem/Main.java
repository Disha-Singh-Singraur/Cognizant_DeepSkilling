public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        System.out.println("--- Adding Tasks ---");
        list.addTask(new Task("T001", "Design Database Schema", "Completed"));
        list.addTask(new Task("T002", "Implement Authentication", "In Progress"));
        list.addTask(new Task("T003", "Write Unit Tests", "Pending"));
        list.traverseTasks();

        System.out.println("\n--- Searching for Task T002 ---");
        Task found = list.searchTask("T002");
        System.out.println("Found: " + found);

        System.out.println("\n--- Deleting Task T001 (Head Element) ---");
        list.deleteTask("T001");
        list.traverseTasks();

        System.out.println("\n--- Deleting Task T003 (Tail Element) ---");
        list.deleteTask("T003");
        list.traverseTasks();

        System.out.println("\n--- Trying to Delete Non-existent Task T999 ---");
        list.deleteTask("T999");
    }
}
