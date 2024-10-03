package ma.ac.esi.referentielCompetences.model;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfilDAO {

	
	
		private String url = "jdbc:mysql://localhost:3306/gestion_competence";
		private String username = "root";
		private String password = "Meryem0101";

		private Connection getConnection() throws SQLException {
			return DriverManager.getConnection(url, username, password);
		}

		public boolean addProfil(Profil Profil) {
			String sql = "INSERT INTO profil (Nom, competences, niveau, salaire) VALUES (?, ?, ?, ?)";

			try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, Profil.getNom());
				pstmt.setString(2, Profil.getCompetences());
				pstmt.setString(3, Profil.getNiveau());
				pstmt.setInt(4, Profil.getSalaire());
				int rowsAffected = pstmt.executeUpdate();
				return rowsAffected > 0;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}

		public List<Profil> getAllProfils() {
			List<Profil> Profils = new ArrayList<>();
			String sql = "SELECT * FROM profil";
			try (Connection conn = getConnection();
					Statement stmt = conn.createStatement();

					ResultSet rs = stmt.executeQuery(sql)) {
				while (rs.next()) {
					Profil Profil = new Profil();
					Profil.setNom(rs.getString("nom"));
					Profil.setCompetences(rs.getString("competences"));
					Profil.setNiveau(rs.getString("niveau"));
					Profil.setSalaire(rs.getInt("salaire"));
					Profils.add(Profil);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return Profils;
		}

		public boolean editerProfil(Profil Profil) {
		    try {
		        Connection conn = getConnection();
		        PreparedStatement pstmt = conn.prepareStatement("UPDATE profil SET Nom=?, competences=?, niveau=?, salaire=? WHERE id_profil=?");
		        pstmt.setString(1, Profil.getNom());
		        pstmt.setString(2, Profil.getCompetences());
		        pstmt.setString(3, Profil.getNiveau());
		        pstmt.setInt(4, Profil.getSalaire());
		        pstmt.setInt(5, Profil.getIdprofil());

		        int rowAffected = pstmt.executeUpdate();
		        return rowAffected > 0;
		    } catch (SQLException e) {
		        e.printStackTrace(); // Afficher la trace complète de l'exception
		        return false;
		    }
		}



			public boolean deleteProfil(String Nom ) {
				try {
					Connection conn = getConnection();
					PreparedStatement delete= conn.prepareStatement("DELETE from profil  where Nom=?");
					delete.setString(1, Nom);
					int resultat = delete.executeUpdate();
					return resultat>0;
				}catch(Exception E) {
				     System.out.println(E.toString());
				     return false;
				}
			}
			
			public List<Profil> filtrer(String salaire, String level) {
			    List<Profil> profiles = new ArrayList<>();
			    String sql = "SELECT * FROM profil  WHERE salaire = ? AND niveau = ?";
			    try (Connection conn = getConnection();
			         PreparedStatement stmt = conn.prepareStatement(sql)) {
			        stmt.setString(1, salaire);
			        stmt.setString(2, level);
			        try (ResultSet rs = stmt.executeQuery()) {
			            while (rs.next()) {
			                Profil profile = new Profil();
			                profile.setNom(rs.getString("nom"));
			                profile.setCompetences(rs.getString("competences"));
			                profile.setNiveau(rs.getString("niveau"));
			                profile.setSalaire(rs.getInt("salaire"));
			                profiles.add(profile);
			            }
			        }
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
			    return profiles;
			}


	}



