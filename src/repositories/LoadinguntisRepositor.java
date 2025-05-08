package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Loadingunit;

public class LoadinguntisRepositor {
    public List<Loadingunit> getAll() {
        String sql = "SELECT * FROM Loadingunit order by luId ASC;";
        //1. Verbindung aufbauen
        ArrayList<Loadingunit> loadingunits = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(Config.URL); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                Loadingunit myLoadingunit = new Loadingunit(rs.getString("luId"));
                myLoadingunit.setStoLocId(rs.getString("stoLocId"));
                myLoadingunit.setLuType(rs.getString("luType"));


                loadingunits.add(myLoadingunit);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return loadingunits;
    }
    
    public Loadingunit getById(String id) {

        String sql = "SELECT * FROM LOADINGUNIT WHERE luId = ?;";
        //1. Verbindung aufbauen

        try (Connection conn = DriverManager.getConnection(Config.URL); //2. "Select * from Item" ausführen
                 PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            //3. Resultat in Objekte der Klasse Item umwandeln
            if (rs.next()) {

                Loadingunit myLoadingunit = new Loadingunit(rs.getString("luId"));
                myLoadingunit.setStoLocId(rs.getString("stoLocId"));
                myLoadingunit.setLuType(rs.getString("luType"));
                

                return myLoadingunit;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());

        }

        //4. Verbindung schließen
        return null;
    }
    
    public void addToDatabase(Loadingunit loadingunit) {
        String sql = "INSERT INTO LOADINGUNIT(luId, stoLocId, luType) VALUES(?,?,?);";

        try (Connection conn = DriverManager.getConnection(Config.URL); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, loadingunit.getLuId());
            pstmt.setString(2, loadingunit.getstoLocId());
            pstmt.setString(3, loadingunit.getluType());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
}
