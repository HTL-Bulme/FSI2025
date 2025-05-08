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
import models.OBO_Line;

public class OBO_LineRepository {

    public List<OBO_Line> getAll() {
        String sql = "SELECT * FROM OBO_LINE ORDER BY orderId ASC, lineNumber ASC;";
        ArrayList<OBO_Line> lines = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(Config.URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                OBO_Line line = new OBO_Line(rs.getString("orderId"), rs.getInt("lineNumber"));
                line.setItemId(rs.getString("itemId"));
                line.setOrderAmount(rs.getInt("orderAmount"));
                line.setDeliveryAmount(rs.getInt("deliveryAmount"));
                lines.add(line);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return lines;
    }

    public OBO_Line getById(String orderId, int lineNumber) {
        String sql = "SELECT * FROM OBO_LINE WHERE orderId = ? AND lineNumber = ?;";
        try (Connection conn = DriverManager.getConnection(Config.URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, orderId);
            stmt.setInt(2, lineNumber);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                OBO_Line line = new OBO_Line(rs.getString("orderId"), rs.getInt("lineNumber"));
                line.setItemId(rs.getString("itemId"));
                line.setOrderAmount(rs.getInt("orderAmount"));
                line.setDeliveryAmount(rs.getInt("deliveryAmount"));
                return line;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public void addToDatabase(OBO_Line line) {
        String sql = "INSERT INTO OBO_LINE(orderId, lineNumber, itemId, orderAmount, deliveryAmount) VALUES(?, ?, ?, ?, ?);";
        try (Connection conn = DriverManager.getConnection(Config.URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, line.getOrderId());
            pstmt.setInt(2, line.getLineNumber());
            pstmt.setString(3, line.getItemId());
            pstmt.setInt(4, line.getOrderAmount());
            pstmt.setInt(5, line.getDeliveryAmount());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void updateInDatabase(OBO_Line line) {
        String sql = "UPDATE OBO_LINE SET itemId = ?, orderAmount = ?, deliveryAmount = ? WHERE orderId = ? AND lineNumber = ?;";
        try (Connection conn = DriverManager.getConnection(Config.URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, line.getItemId());
            pstmt.setInt(2, line.getOrderAmount());
            pstmt.setInt(3, line.getDeliveryAmount());
            pstmt.setString(4, line.getOrderId());
            pstmt.setInt(5, line.getLineNumber());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}