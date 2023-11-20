import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String studentId;
    private String name;
    private ArrayList<Double> grades;
    private int attendance;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.grades = new ArrayList<>();
        this.attendance = 0;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getGrades() {
        return grades;
    }

    public int getAttendance() {
        return attendance;
    }

    public void updateAttendance() {
        attendance++;
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void updateStudentAttendance(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                student.updateAttendance();
                System.out.println("Attendance updated for " + student.getName());
                return;
            }
        }
        System.out.println("Student not found with ID: " + studentId);
    }

    public void addStudentGrade(String studentId, double grade) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                student.addGrade(grade);
                System.out.println("Grade added for " + student.getName());
                return;
            }
        }
        System.out.println("Student not found with ID: " + studentId);
    }

    public void displayStudentInfo(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                System.out.println("Student ID: " + student.getStudentId());
                System.out.println("Name: " + student.getName());
                System.out.println("Attendance: " + student.getAttendance());
                System.out.println("Grades: " + student.getGrades());
                return;
            }
        }
        System.out.println("Student not found with ID: " + studentId);
    }

    public void removeStudent(String studentId) {
        students.removeIf(student -> student.getStudentId().equals(studentId));
        System.out.println("Student removed with ID: " + studentId);
    }

    public void generateReport() {
        System.out.println("Student Report:");
        for (Student student : students) {
            System.out.println("Student ID: " + student.getStudentId());
            System.out.println("Name: " + student.getName());
            System.out.println("Attendance: " + student.getAttendance());
            System.out.println("Grades: " + student.getGrades());
            System.out.println("--------------------------");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Update Attendance");
            System.out.println("3. Add Grade");
            System.out.println("4. Display Student Information");
            System.out.println("5. Remove Student");
            System.out.println("6. Generate Report");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    system.addStudent(new Student(studentId, name));
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    String attendanceId = scanner.nextLine();
                    system.updateStudentAttendance(attendanceId);
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    String gradeId = scanner.nextLine();
                    System.out.print("Enter Grade: ");
                    double grade = scanner.nextDouble();
                    system.addStudentGrade(gradeId, grade);
                    break;
                case 4:
                    System.out.print("Enter Student ID: ");
                    String infoId = scanner.nextLine();
                    system.displayStudentInfo(infoId);
                    break;
                case 5:
                    System.out.print("Enter Student ID: ");
                    String removeId = scanner.nextLine();
                    system.removeStudent(removeId);
                    break;
                case 6:
                    system.generateReport();
                    break;
                case 7:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
