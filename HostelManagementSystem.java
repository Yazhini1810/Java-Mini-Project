package project1;
import java.util.*;

class Student {
    int id;
    String name;
    int months;
    double rent;

    Student(int id, String name, int months, double rent) {
        this.id = id;
        this.name = name;
        this.months = months;
        this.rent = rent;
    }

    void display() {
        System.out.println(id + "\t" + name + "\t" + months + "\t" + rent);
    }
}

public class HostelManagementSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("HOSTEL MANAGEMENT SYSTEM");
                System.out.println("------------------------");
                System.out.println("1.Admin Login");
                System.out.println("2.Student Login");
                System.out.println("3.Exit");
                System.out.print("Enter choice: ");
                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        adminLogin();
                        break;
                    case 2:
                        studentMenu();
                        break;
                    case 3:
                        System.out.println("Thank You");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Invalid input Try again.");
                sc.next();
            }
        }
    }
    
    static void adminLogin() {
        System.out.print("Enter Admin Username: ");
        String user = sc.next();
        System.out.print("Enter Password ");
        String pass = sc.next();

        if (user.equals("admin") && pass.equals("1234")) {
            adminMenu();
        } else {
            System.out.println("Invalid Login");
        }
    }

    static void adminMenu() {
        while (true) {
            try {
                System.out.println("\n----- ADMIN MENU -----");
                System.out.println("1.Add Student");
                System.out.println("2.View Students");
                System.out.println("3.Update Student");
                System.out.println("4.Delete Student");
                System.out.println("5.Logout");
                System.out.print("Enter choice: ");
                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        viewStudents();
                        break;
                    case 3:
                        updateStudent();
                        break;
                    case 4:
                        deleteStudent();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid Choice");
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
                sc.next();
            }
        }
    }

    static void addStudent() {
        try {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            System.out.print("Enter Name: ");
            String name = sc.next();
            System.out.print("Stayed Months: ");
            int m = sc.nextInt();
            System.out.print("Monthly Rent: ");
            double r = sc.nextDouble();

            students.add(new Student(id, name, m, r));
            System.out.println("Student Added Successfully");
        } catch (Exception e) {
            System.out.println("Invalid Input");
            sc.next();
        }
    }

    static void viewStudents() {
        System.out.println("\nID \tName \tMonths \tRent");
        System.out.println("------------------------------");
        for (Student s : students) {
            s.display();
        }
    }

    static void updateStudent() {
        System.out.print("Enter Student ID to Update: ");
        int id = sc.nextInt();
        boolean found = false;

        for (Student s : students) {
            if (s.id == id) {
                System.out.print("New Name: ");
                s.name = sc.next();
                System.out.print("New Months: ");
                s.months = sc.nextInt();
                System.out.print("New Rent: ");
                s.rent = sc.nextDouble();
                System.out.println("Updated Successfully");
                found = true;
            }
        }
        if (!found)
            System.out.println("Student Not Found");
    }

    static void deleteStudent() {
        System.out.print("Enter Student ID to Delete: ");
        int id = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).id == id) {
                students.remove(i);
                found = true;
                System.out.println("Deleted Successfully");
                break;
            }
        }

        if (!found)
            System.out.println("Student Not Found");
    }


    static void studentMenu() {
        while (true) {
            try {
                System.out.println("\n----- STUDENT MENU -----");
                System.out.println("1. View Available Rooms & Rent");
                System.out.println("2. View Food Menu");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");
                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        viewRooms();
                        break;
                    case 2:
                        foodMenu();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Invalid Choice");
                }
            } catch (Exception e) {
                System.out.println("Invalid Input!");
                sc.next();
            }
        }
    }

    static void viewRooms() {
        System.out.println("\nRoom Type\tAvailable\tRent");
        System.out.println("-----------------------------------");
        System.out.println("Single\t\t3\t\t5000");
        System.out.println("Double\t\t5\t\t3500");
        System.out.println("Shared\t\t8\t\t2500");
    }

    static void foodMenu() {
        System.out.println("\n----- FOOD MENU -----");
        System.out.println("Breakfast: Idli, Dosa, Pongal, Tea");
        System.out.println("Lunch: Rice, Sambar, Rasam, Veg Curry");
        System.out.println("Dinner: Chapati, Dosa, Fried Rice");
    }
}
