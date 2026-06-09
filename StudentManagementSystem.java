import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Student Grade Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Calculate Average Marks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    String id = input.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = input.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = input.nextDouble();

                    students.add(new Student(id, name, marks));
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    System.out.println("\nStudent List:");
                    for (Student s : students) {
                        System.out.println(s);
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID to search: ");
                    String searchId = input.nextLine();

                    boolean found = false;

                    for (Student s : students) {
                        if (s.getStudentId().equals(searchId)) {
                            System.out.println("Student Found:");
                            System.out.println(s);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    if (students.size() == 0) {
                        System.out.println("No students available.");
                    } else {
                        double total = 0;

                        for (Student s : students) {
                            total += s.getMarks();
                        }

                        double average = total / students.size();

                        System.out.println("Average Marks: " + average);
                    }
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    input.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}