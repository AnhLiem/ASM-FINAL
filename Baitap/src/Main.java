import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement management = new StudentManagement();

        while (true) {
            try {
                System.out.println("\n=== MENU ===");
                System.out.println("1. Add Student");
                System.out.println("2. Display Student List");
                System.out.println("3. Update Student Score");
                System.out.println("4. Delete Student");
                System.out.println("5. Search Student");
                System.out.println("6. Sort Students by Score");
                System.out.println("7. Sort Students by Name");
                System.out.println("8. Exit");
                System.out.print("Choose an option (1-8): ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        String id;
                        while (true) {
                            System.out.print("Enter Student ID: ");
                            id = scanner.nextLine().trim();
                            if (!id.isEmpty()) { // Ensure ID is not empty
                                break;
                            } else {
                                System.out.println("Student ID cannot be empty! Please try again.");
                            }
                        }

                        String name;
                        while (true) {
                            System.out.print("Enter Student Name: ");
                            name = scanner.nextLine();
                            if (name.matches("[a-zA-Z\\s]+")) { // Validate name contains only letters and spaces
                                break;
                            } else {
                                System.out.println("Invalid name! Please enter only letters.");
                            }
                        }

                        double score;
                        while (true) {
                            System.out.print("Enter Student Score (0-10): ");
                            try {
                                score = Double.parseDouble(scanner.nextLine()); // Parse score as double
                                if (score >= 0 && score <= 10) {
                                    break; // Valid score range
                                } else {
                                    System.out.println("Invalid score! Please enter a value between 0 and 10.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Score must be a number! Please try again.");
                            }
                        }

                        management.addLast(new Student(id, name, score));
                        System.out.println("Student added successfully.");
                        break;

                    case 2:
                        management.traverse();
                        break;

                    case 3:
                        System.out.print("Enter Student ID to update: ");
                        id = scanner.nextLine();

                        while (true) {
                            System.out.print("Enter new score (0-10): ");
                            score = Double.parseDouble(scanner.nextLine());
                            if (score >= 0 && score <= 10) {
                                break;
                            } else {
                                System.out.println("Invalid score! Please enter a value between 0 and 10.");
                            }
                        }
                        management.updateStudent(id, score);
                        break;

                    case 4:
                        System.out.print("Enter Student ID to delete: ");
                        id = scanner.nextLine();
                        management.deleteById(id);
                        break;

                    case 5:
                        System.out.print("Enter Student ID to search: ");
                        id = scanner.nextLine();
                        Student student = management.searchById(id);
                        if (student != null) {
                            System.out.println(student);
                        } else {
                            System.out.println("Student not found!");
                        }
                        break;

                    case 6:
                        management.bubbleSortByScore();
                        break;

                    case 7:
                        management.insertionSortByName();
                        break;

                    case 8:
                        System.out.println("Exiting program.");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input error! Please enter an integer.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}
