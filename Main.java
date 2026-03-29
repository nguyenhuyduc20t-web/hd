import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        int numberOfStudents = 0;

        // Input number of students
        while (true) {
            try {
                System.out.print("Enter number of students to manage: ");
                numberOfStudents = Integer.parseInt(sc.nextLine());
                if (numberOfStudents <= 0) {
                    System.out.println("Number must be greater than 0!");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter again!");
            }
        }

        int choice;

        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Sort by Marks (Bubble Sort)");
            System.out.println("5. Sort by Marks (Descending - Bubble Sort)");
            System.out.println("6. Sort by Name");
            System.out.println("7. Search by ID");
            System.out.println("8. Search by Name");
            System.out.println("9. Display All Students");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("You entered an invalid option. Please try again!");
                continue;
            }

            if (choice == 0) {
                System.out.println("Program terminated.");
                break;
            }

            switch (choice) {
                case 1 -> {
                    try {
                        System.out.print("Student ID: ");
                        String id = sc.nextLine();

                        System.out.print("Student Name: ");
                        String name = sc.nextLine();

                        double marks;
                        while (true) {
                            try {
                                System.out.print("Student Marks (0-10): ");
                                marks = Double.parseDouble(sc.nextLine());
                                if (marks < 0 || marks > 10) {
                                    System.out.println("Marks must be between 0 and 10!");
                                    continue;
                                }
                                break;
                            } catch (Exception e) {
                                System.out.println("Invalid marks. Please enter again!");
                            }
                        }

                        manager.addStudent(new Student(id, name, marks));
                    } catch (Exception e) {
                        System.out.println("Error while adding student.");
                    }
                }

                case 2 -> {
                    System.out.print("Enter Student ID to edit: ");
                    String id = sc.nextLine();

                    System.out.print("New Name: ");
                    String name = sc.nextLine();

                    double marks;
                    while (true) {
                        try {
                            System.out.print("New Marks: ");
                            marks = Double.parseDouble(sc.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid marks. Enter again!");
                        }
                    }

                    manager.editStudent(id, name, marks);
                }

                case 3 -> {
                    System.out.print("Enter Student ID to delete: ");
                    manager.deleteStudent(sc.nextLine());
                }

                case 4 -> manager.bubbleSortByMarks();
                case 5 -> manager.bubbleSortByMarkss();
                case 6 -> manager.sortByName();

                case 7 -> {
                    System.out.print("Enter Student ID: ");
                    Student s = manager.searchById(sc.nextLine());
                    System.out.println(s == null ? "Student not found!" : s);
                }

                case 8 -> {
                    System.out.print("Enter Student Name: ");
                    Student s = manager.linearSearchByName(sc.nextLine());
                    System.out.println(s == null ? "Student not found!" : s);
                }

                case 9 -> manager.displayAll();

                default -> System.out.println("Invalid option. Please try again!");
            }
        }
    }
}
