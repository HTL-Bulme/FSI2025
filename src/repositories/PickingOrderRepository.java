/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

/**
 *
 * @author julianp
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import models.PickingOrder;

public class PickingOrderRepository {

    public List<PickingOrder> getAll() {
        String sql = "SELECT * FROM PickingOrder ORDER BY pickingOrderId ASC, lineNumber ASC;";
        ArrayList<PickingOrder> list = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(Config.URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                PickingOrder line = new PickingOrder();
                line.setCurrentUser(rs.getString("currentUser"));
                line.setPickingOrderId(rs.getLong("pickingOrderId"));
                line.setStartTime(rs.getTimestamp("startTime"));
                line.setFinishTime(rs.getTimestamp("finishTime"));
                line.setCurrentUser(rs.getString("currentUser"));
                line.setCustomerId(rs.getString("customerId"));
                line.setDeliveryTime(rs.getTimestamp("deliveryTime"));
                list.add(line);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return list;
    }

    public PickingOrder getById(Long pickingOrderId, Long lineNumber) {
        String sql = "SELECT * FROM PickingOrder WHERE pickingOrderId = ? AND lineNumber = ?;";

        try (Connection conn = DriverManager.getConnection(Config.URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, pickingOrderId);
            stmt.setLong(2, lineNumber);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                PickingOrder line = new PickingOrder();
                line.setCurrentUser(rs.getString("currentUser"));
                line.setPickingOrderId(rs.getLong("pickingOrderId"));
                line.setStartTime(rs.getTimestamp("startTime"));
                line.setFinishTime(rs.getTimestamp("finishTime"));
                line.setCurrentUser(rs.getString("currentUser"));
                line.setCustomerId(rs.getString("customerId"));
                line.setDeliveryTime(rs.getTimestamp("deliveryTime"));
                return line;
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return null;
    }

    public void addToDatabase(PickingOrder line) {
        String sql = "INSERT INTO PickingOrder(pickingOrderId, startTime, finishTime, currentUser, customerId, deliveryTime) VALUES (?, ?, ?, ?, ?, ?);";
        try (Connection conn = DriverManager.getConnection(Config.URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, line.getPickingOrderId());
            pstmt.setTimestamp(2, line.getStartTime());
            pstmt.setTimestamp(3, line.getFinishTime());
            pstmt.setString(4, line.getCurrentUser());
            pstmt.setString(5, line.getCustomerId());
            pstmt.setTimestamp(6, line.getDeliveryTime());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void updateInDatabase(PickingOrder line) {
        String sql = "UPDATE PickingOrder SET startTime = ?, finishTime = ?, currentUser = ?, customerId = ?, deliveryTime = ?, WHERE pickingOrderId = ?;";

        try (Connection conn = DriverManager.getConnection(Config.URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            
            pstmt.setTimestamp(1, line.getStartTime());
            pstmt.setTimestamp(2, line.getFinishTime());
            pstmt.setString(3, line.getCurrentUser());
            pstmt.setString(4, line.getCustomerId());
            pstmt.setTimestamp(5, line.getDeliveryTime());
            pstmt.setLong(6, line.getPickingOrderId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
