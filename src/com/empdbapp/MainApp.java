package com.empdbapp;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        EmpDatabaseApp dao = new EmpDatabaseApp();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Employee Database Menu ====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                	System.out.print("Enter Name: ");
                    sc.nextLine(); // buffer clear
                    String name = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    System.out.print("Enter Department: ");
                    sc.nextLine(); // buffer clear
                    String dept = sc.nextLine();

                    dao.addEmployee(name, salary, dept);
                    break;

                case 2:
             
                    dao.viewEmployees();
                    break;

                case 3:
                    System.out.print("Enter Employee ID to update: ");
                    int id = sc.nextInt();
                    System.out.print("Enter New Salary: ");
                    double newSal = sc.nextDouble();
                    dao.updateEmployee(id, newSal);
                    break;

                case 4:
                    System.out.print("Enter Employee ID to delete: ");
                    int delId = sc.nextInt();
                    dao.deleteEmployee(delId);
                    break;

                case 5:
                    System.out.println("Exiting... Bye!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice! Try again.");
            }
        }
    }
}

