/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.OutboundOrder;

public class OutboundOrderRepository {

    public List<OutboundOrder> getAll() {
        String sql = "SELECT * FROM OUTBOUNDORDER ORDER BY orderId ASC;";
        ArrayList<OutboundOrder> orders = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(Config.URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                OutboundOrder order = new OutboundOrder(rs.getString("orderId"));
                order.setPickingOrder(rs.getInt("pickingOrderId"));
                order.setState(rs.getString("state"));
                order.setCustomerId(rs.getString("customerId"));
                order.setDeliveryTime(rs.getTimestamp("deliveryTime"));
                orders.add(order);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return orders;
    }

    public OutboundOrder getById(String id) {
        String sql = "SELECT * FROM OUTBOUNDORDER WHERE orderId = ?;";
        try (Connection conn = DriverManager.getConnection(Config.URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                OutboundOrder order = new OutboundOrder(rs.getString("orderId"));
                order.setPickingOrder(rs.getInt("pickingOrderId"));
                order.setState(rs.getString("state"));
                order.setCustomerId(rs.getString("customerId"));
                order.setDeliveryTime(rs.getTimestamp("deliveryTime"));
                return order;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public void addToDatabase(OutboundOrder order) {
        String sql = "INSERT INTO OUTBOUNDORDER(orderId, pickingOrderId, state, customerId, deliveryTime) VALUES(?, ?, ?, ?, ?);";
        try (Connection conn = DriverManager.getConnection(Config.URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, order.getOrderId());
            pstmt.setLong(2, order.getPickingOrder());
            pstmt.setString(3, order.getState());
            pstmt.setString(4, order.getCustomerId());
            pstmt.setTimestamp(5, order.getDeliveryTime());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void updateInDatabase(OutboundOrder order) {
        String sql = "UPDATE OUTBOUNDORDER SET pickingOrderId = ?, state = ?, customerId = ?, deliveryTime = ? WHERE orderId = ?;";
        try (Connection conn = DriverManager.getConnection(Config.URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, order.getPickingOrder());
            pstmt.setString(2, order.getState());
            pstmt.setString(3, order.getCustomerId());
            pstmt.setTimestamp(4, order.getDeliveryTime());
            pstmt.setString(5, order.getOrderId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}