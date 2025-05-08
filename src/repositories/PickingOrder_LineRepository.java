package repositories;

import models.PickingOrder_Line;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PickingOrder_LineRepository {

    public List<PickingOrder_Line> getAll() {
        String sql = "SELECT * FROM PickingOrder_Line ORDER BY pickingOrderId ASC, lineNumber ASC;";
        ArrayList<PickingOrder_Line> list = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(Config.URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                PickingOrder_Line line = new PickingOrder_Line();
                // Assuming setters are added in your model
                // You'll need to add these if missing
                line.setPickSequence(rs.getLong("pickSequence"));
                line.setItemName(rs.getString("itemName"));
                line.setOrderAmount(rs.getLong("orderAmount"));
                line.setBoockingAmount(rs.getLong("boockingAmount"));
                line.setTargetStockObject(rs.getString("targetStockObject"));
                // Add additional setters if present in the model
                list.add(line);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return list;
    }

    public PickingOrder_Line getById(Long pickingOrderId, Long lineNumber) {
        String sql = "SELECT * FROM PickingOrder_Line WHERE pickingOrderId = ? AND lineNumber = ?;";

        try (Connection conn = DriverManager.getConnection(Config.URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, pickingOrderId);
            stmt.setLong(2, lineNumber);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                PickingOrder_Line line = new PickingOrder_Line();
                line.setPickSequence(rs.getLong("pickSequence"));
                line.setItemName(rs.getString("itemName"));
                line.setOrderAmount(rs.getLong("orderAmount"));
                line.setBoockingAmount(rs.getLong("boockingAmount"));
                line.setTargetStockObject(rs.getString("targetStockObject"));
                return line;
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return null;
    }

    public void addToDatabase(PickingOrder_Line line) {
        String sql = "INSERT INTO PickingOrder_Line(pickingOrderId, lineNumber, pickSequence, stoLocId, itemId, itemName, orderAmount, boockingAmount, targetLuId, targetStockObject) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try (Connection conn = DriverManager.getConnection(Config.URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, line.getPickingOrderId());
            pstmt.setLong(2, line.getLineNumber());
            pstmt.setLong(3, line.getPickSequence());
            pstmt.setString(4, line.getStoLocId());
            pstmt.setString(5, line.getItemId());
            pstmt.setString(6, line.getItemName());
            pstmt.setLong(7, line.getOrderAmount());
            pstmt.setLong(8, line.getBoockingAmount());
            pstmt.setString(9, line.getTargetLuId());
            pstmt.setString(10, line.getTargetStockObject());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void updateInDatabase(PickingOrder_Line line) {
        String sql = "UPDATE PickingOrder_Line SET pickSequence = ?, stoLocId = ?, itemId = ?, itemName = ?, orderAmount = ?, boockingAmount = ?, targetLuId = ?, targetStockObject = ? WHERE pickingOrderId = ? AND lineNumber = ?;";

        try (Connection conn = DriverManager.getConnection(Config.URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, line.getPickSequence());
            pstmt.setString(2, line.getStoLocId());
            pstmt.setString(3, line.getItemId());
            pstmt.setString(4, line.getItemName());
            pstmt.setLong(5, line.getOrderAmount());
            pstmt.setLong(6, line.getBoockingAmount());
            pstmt.setString(7, line.getTargetLuId());
            pstmt.setString(8, line.getTargetStockObject());
            pstmt.setLong(9, line.getPickingOrderId());
            pstmt.setLong(10, line.getLineNumber());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
