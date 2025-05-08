/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

/**
 *
 * @author gl
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.User;

public class UserRepository {

    public List<User> getAll() {
        String sql = "SELECT * FROM USER ORDER BY userId ASC;";
        ArrayList<User> users = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(Config.URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                User user = new User(rs.getString("userId"));
                user.setUserName(rs.getString("name"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return users;
    }

    public User getById(String id) {
        String sql = "SELECT * FROM USER WHERE userId = ?;";
        try (Connection conn = DriverManager.getConnection(Config.URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getString("userId"));
                user.setUserName(rs.getString("name"));
                return user;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public void addToDatabase(User user) {
        String sql = "INSERT INTO USER(userId, name) VALUES(?, ?);";
        try (Connection conn = DriverManager.getConnection(Config.URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getUserName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void updateInDatabase(User user) {
        String sql = "UPDATE USER SET name = ? WHERE userId = ?;";
        try (Connection conn = DriverManager.getConnection(Config.URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getUserId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
