package ma.ac.esi.referentielCompetences.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectBd {
	
	private String url = "jdbc:mysql://localhost/gestion_competence";
    private String username = "root";
    private String password = "Meryem0101";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public boolean FindUser(String email, String psswd) {
        String sql = "SELECT * FROM user WHERE email = ? AND psswd = ?";
        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setString(1, email);
            pstmt.setString(2, psswd);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next(); 
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
            return false; 
        }
    }
    
    public boolean FindAdmin(String email, String psswd) {
        String sql = "SELECT * FROM user WHERE email = ? AND psswd = ? AND type = 1";
        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setString(1, email);
            pstmt.setString(2, psswd);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next(); 
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
            return false; 
        }
    }

    
    public boolean Findpsswd(String email, String nom, String prenom) {
        String sql = "SELECT * FROM user WHERE email = ? AND nom = ? AND prenom =? ";
        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setString(1, email);
            pstmt.setString(2, nom);
            pstmt.setString(3, prenom);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next(); 
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
            return false; 
        }
    }
    
    
    public boolean Updatepsswd( String psswd,String psswd1, String email) {
        String sql = "UPDATE user SET psswd = ? WHERE email = ?";
        
        
        if(psswd.equals(psswd1)) {
        	try (
                    Connection conn = getConnection();
                    PreparedStatement pstmt = conn.prepareStatement(sql)
                ) {
                    pstmt.setString(1, psswd);
                    pstmt.setString(2, email);
                    int rowsAffected = pstmt.executeUpdate();
                    
                    
                    return rowsAffected > 0;
                } catch (SQLException e) {
                    e.printStackTrace();
                    return false;
                }
        }
        else {
                    return false;
        }
    }
    
    public boolean AddUser(String nom, String prenom, String email, String psswd) {
        String sql = "INSERT INTO user (nom, prenom, email, psswd, type) VALUES (?, ?, ?, ?, 0)";
        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setString(1, nom);
            pstmt.setString(2, prenom);
            pstmt.setString(3, email);
            pstmt.setString(4, psswd);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

 
   
}
