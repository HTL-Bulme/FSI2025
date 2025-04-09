package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Stoloc;

public class StolocRepository {

    public List<Stoloc> getAll() {
        String sql = "SELECT * FROM STOLOC order by stoLocId ASC;";
        //1. Verbindung aufbauen
        ArrayList<Stoloc> stolocs = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(Config.URL); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                Stoloc myStoloc = new Stoloc(rs.getString("stoLocId"));
                myStoloc.setPickSequence(rs.getLong("pickSequence"));

                stolocs.add(myStoloc);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return stolocs;
    }

    public Stoloc getById(String id) {

        String sql = "SELECT * FROM STOLOC WHERE stoLocId = ?;";

        try (Connection conn = DriverManager.getConnection(Config.URL); PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Stoloc myStoloc = new Stoloc(rs.getString("stoLocId"));
                myStoloc.setPickSequence(rs.getLong("pickSequence"));

                return myStoloc;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());

        }
        return null;
    }

    public void addToDatabase(Stoloc stoloc) {
        String sql = "INSERT INTO STOLOC(stoLocId, pickSequence) VALUES(?,?);";

        try (Connection conn = DriverManager.getConnection(Config.URL); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, stoloc.getStoLocId());
            pstmt.setLong(2, stoloc.getPickSequence());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void updateInDatabase(Stoloc stoloc) {
        String sql = "UPDATE STOLOC SET pickSequence = ? where stoLocId = ?;";
        try (Connection conn = DriverManager.getConnection(Config.URL); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, stoloc.getPickSequence());
            pstmt.setString(2, stoloc.getStoLocId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
