/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

/**
 *
 * @author aslan
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Customer;

public class CustomerRepository {

    public List<Customer> getAll() {
        String sql = "SELECT * FROM CUSTOMER ORDER BY customerId ASC;";
        ArrayList<Customer> customers = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(Config.URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Customer customer = new Customer(rs.getString("customerId"));
                customer.setAllowedLuType(rs.getString("allowedLuType"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return customers;
    }

    public Customer getById(String id) {
        String sql = "SELECT * FROM CUSTOMER WHERE customerId = ?;";
        try (Connection conn = DriverManager.getConnection(Config.URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Customer customer = new Customer(rs.getString("customerId"));
                customer.setAllowedLuType(rs.getString("allowedLuType"));
                return customer;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public void addToDatabase(Customer customer) {
        String sql = "INSERT INTO CUSTOMER(customerId, allowedLuType) VALUES(?, ?);";
        try (Connection conn = DriverManager.getConnection(Config.URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, customer.getCustomerId());
            pstmt.setString(2, customer.getAllowedLuType());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void updateInDatabase(Customer customer) {
        String sql = "UPDATE CUSTOMER SET allowedLuType = ? WHERE customerId = ?;";
        try (Connection conn = DriverManager.getConnection(Config.URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, customer.getAllowedLuType());
            pstmt.setString(2, customer.getCustomerId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}

