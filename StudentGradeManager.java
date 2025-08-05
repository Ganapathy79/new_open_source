import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    String id;
    double marks;

    public Student(String name, String id, double marks) {
        this.name = name;
        this.id = id;
        this.marks = marks;
    }

    public String getGrade() {
        if (marks >= 90) return "A";
        else if (marks >= 80) return "B";
        else if (marks >= 70) return "C";
        else if (marks >= 60) return "D";
        else return "F";
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks + ", Grade: " + getGrade();
    }
}

public class StudentGradeManager {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n---- Student Grade Management System ----");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    searchStudentById();
                    break;
                case 4:
                    System.out.println("Exiting... Bye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }

    static void addStudent() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter student ID: ");
        String id = sc.nextLine();
        System.out.print("Enter marks: ");
        double marks = sc.nextDouble();
        students.add(new Student(name, id, marks));
        System.out.println("✅ Student added successfully.");
    }

    static void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("\n--- Student Records ---");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    static void searchStudentById() {
        System.out.print("Enter student ID to search: ");
        String id = sc.nextLine();
        boolean found = false;
        for (Student s : students) {
            if (s.id.equalsIgnoreCase(id)) {
                System.out.println(s);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Student not found.");
        System.err.println("uio");
    }
}
