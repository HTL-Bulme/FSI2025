/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

/**
 *
 * @author Philipp
 */

import java.sql.Connection;
import models.Item;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.StockObjekt;


public class StockObjektRepository {
    
    public List<StockObjekt> getAll() {
        String sql = "SELECT * FROM STOCKOBJECT order by luld ASC;";
        //1. Verbindung aufbauen
        ArrayList<StockObjekt> items = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(Config.URL); //2. "Select * from Item" ausführen
                 Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            //3. Resultat in Objekte der Klasse Item umwandeln
            while (rs.next()) {

                StockObjekt myStockObjekt = new StockObjekt(rs.getString("luld"));
                myStockObjekt.setIteamName(rs.getString("iteamName"));
                myStockObjekt.setIteamId(rs.getString("stockObjekt"));
                myStockObjekt.setAmount(rs.getLong("amount"));
                
                items.add(myStockObjekt);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        //4. Verbindung schließen
        return items;
    }

    public Item getById(String id1,String id2) {

        String sql = "SELECT * FROM STOCKOBJEKT WHERE luld = ? and stockObjektNumber = ?;";
        //1. Verbindung aufbauen

        try (Connection conn = DriverManager.getConnection(Config.URL); //2. "Select * from Item" ausführen
                 PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, id1);
            ResultSet rs = stmt.executeQuery();
            //3. Resultat in Objekte der Klasse Item umwandeln
            if (rs.next()) {

                StockObjekt myStockObjekt = new StockObjekt(rs.getString("luld"));
                myStockObjekt.setIteamName(rs.getString("iteamName"));
                myStockObjekt.setIteamId(rs.getString("stockObjekt"));
                myStockObjekt.setAmount(rs.getLong("amount"));
                
                

                return myStockObjekt;
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
