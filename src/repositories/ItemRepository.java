package repositories;

import java.sql.Connection;
import models.Item;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemRepository {

    public List<Item> getAll() {
        String sql = "SELECT * FROM ITEM order by itemId ASC;";
        //1. Verbindung aufbauen
        ArrayList<Item> items = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(Config.URL); //2. "Select * from Item" ausführen
                 Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            //3. Resultat in Objekte der Klasse Item umwandeln
            while (rs.next()) {

                Item myItem = new Item(rs.getString("itemId"));
                myItem.setName(rs.getString("name"));
                myItem.setItemLength(rs.getInt("itemLength"));
                myItem.setItemWidth(rs.getInt("itemWidth"));
                myItem.setItemHeight(rs.getInt("itemHeight"));
                myItem.setPickingStoLoc(rs.getString("pickingStoLoc"));

                items.add(myItem);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        //4. Verbindung schließen
        return items;
    }

    public Item getById(String id) {

        String sql = "SELECT * FROM ITEM WHERE itemId = ?;";
        //1. Verbindung aufbauen

        try (Connection conn = DriverManager.getConnection(Config.URL); //2. "Select * from Item" ausführen
                 PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            //3. Resultat in Objekte der Klasse Item umwandeln
            if (rs.next()) {

                Item myItem = new Item(rs.getString("itemId"));
                myItem.setName(rs.getString("name"));
                myItem.setItemLength(rs.getInt("itemLength"));
                myItem.setItemWidth(rs.getInt("itemWidth"));
                myItem.setItemHeight(rs.getInt("itemHeight"));
                myItem.setPickingStoLoc(rs.getString("pickingStoLoc"));

                return myItem;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());

        }

        //4. Verbindung schließen
        return null;
    }

    public void addToDatabase(Item item) {
        String sql = "INSERT INTO ITEM(itemId, name, itemLength, itemWidth, itemHeight, pickingStoLoc) VALUES(?,?,?,?,?,?);";

        try (Connection conn = DriverManager.getConnection(Config.URL); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, item.getItemId());
            pstmt.setString(2, item.getName());
            pstmt.setLong(3, item.getItemLength());
            pstmt.setLong(4, item.getItemWidth());
            pstmt.setLong(5, item.getItemHeight());
            pstmt.setString(6, item.getPickingStoLoc());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void updateInDatabase(Item item) {
        String sql = "UPDATE ITEM SET name = ?, itemLength = ?, itemWidth = ?, itemHeight = ?, pickingStoLoc = ? where itemId = ?;";
        try (Connection conn = DriverManager.getConnection(Config.URL); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, item.getName());
            pstmt.setLong(2, item.getItemLength());
            pstmt.setLong(3, item.getItemWidth());
            pstmt.setLong(4, item.getItemHeight());
            pstmt.setString(5, item.getPickingStoLoc());
            pstmt.setString(6, item.getItemId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
