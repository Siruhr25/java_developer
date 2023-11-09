import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String name;
    String description;
    String dueDate;

    public Task(String name, String description, String dueDate) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
    }
}

public class TaskManager {
    ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(String name, String description, String dueDate) {
        Task task = new Task(name, description, dueDate);
        tasks.add(task);
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                System.out.println((i + 1) + ". Name: " + task.name + ", Description: " + task.description + ", Due Date: " + task.dueDate);
            }
        }
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTask Management System");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. List Tasks");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();

                    System.out.print("Enter due date: ");
                    String dueDate = scanner.nextLine();

                    taskManager.addTask(name, description, dueDate);
                    break;

                case 2:
                    System.out.print("Enter the index of the task to remove: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    taskManager.removeTask(index - 1);
                    break;

                case 3:
                    taskManager.listTasks();
                    break;

                case 4:
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
