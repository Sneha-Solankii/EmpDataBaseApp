package com.empdbapp;

import java.sql.*;

public class EmpDatabaseApp {
    
    // Add Employee
    public void addEmployee(String name, double salary, String dept) {
        String sql = "INSERT INTO employees(name, salary, department) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, name);
            pst.setDouble(2, salary);
            pst.setString(3, dept);
            pst.executeUpdate();
            System.out.println("Employee Added!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View Employees
    public void viewEmployees() {
        String sql = "SELECT * FROM employees";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                                   rs.getString("name") + " | " +
                                   rs.getDouble("salary") + " | " +
                                   rs.getString("department"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update Employee
    public void updateEmployee(int id, double newSalary) {
        String sql = "UPDATE employees SET salary=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setDouble(1, newSalary);
            pst.setInt(2, id);
            pst.executeUpdate();
            System.out.println("Employee Updated!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Employee
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Employee Deleted!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}