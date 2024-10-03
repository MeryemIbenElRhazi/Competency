package ma.ac.esi.referentielCompetences.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SkillDAO {
	private String url = "jdbc:mysql://localhost:3306/gestion_competence";
	private String username = "root";
	private String password = "Meryem0101";

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

	public boolean addSkill(Skill skill) {
		String sql = "INSERT INTO competence (nom, description, domaine, niveau) VALUES(?, ?, ?, ?)";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, skill.getName());
			pstmt.setString(2, skill.getDescription());
			pstmt.setString(3, skill.getDomain());
			pstmt.setString(4, skill.getLevel());
			int rowsAffected = pstmt.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Skill> getAllSkills() {
		List<Skill> skills = new ArrayList<>();
		String sql = "SELECT * FROM competence";
		try (Connection conn = getConnection();
				Statement stmt = conn.createStatement();

				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				Skill skill = new Skill();
				skill.setId(rs.getInt("idcompetence"));
				skill.setName(rs.getString("nom"));
				skill.setDescription(rs.getString("description"));
				skill.setDomain(rs.getString("domaine"));
				skill.setLevel(rs.getString("niveau"));
				skills.add(skill);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return skills;
	}

	public boolean editerSkill(Skill skill) {
	    try {
	        Connection conn = getConnection();
	        PreparedStatement pstmt = conn.prepareStatement("UPDATE competence SET nom=?, description=?, domaine=?, niveau=? WHERE idcompetence=?");
	        pstmt.setString(1, skill.getName());
	        pstmt.setString(2, skill.getDescription());
	        pstmt.setString(3, skill.getDomain());
	        pstmt.setString(4, skill.getLevel());
	        pstmt.setInt(5, skill.getId());

	        int rowAffected = pstmt.executeUpdate();
	        return rowAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace(); // Afficher la trace complète de l'exception
	        return false;
	    }
	}



		public boolean deleteskill(int id ) {
			try {
				Connection conn = getConnection();
				PreparedStatement delete= conn.prepareStatement("DELETE from competence where idcompetence=?");
				delete.setInt(1, id);
				int resultat = delete.executeUpdate();
				return resultat>0;
			}catch(Exception E) {
			     System.out.println(E.toString());
			     return false;
			}
		}
		public List<Skill> filtrer(String domain, String level) {
		    List<Skill> competences = new ArrayList<>();
		    String sql = "SELECT * FROM competence WHERE domaine = ? AND niveau = ?";
		    try (Connection conn = getConnection();
		         PreparedStatement stmt = conn.prepareStatement(sql)) {
		        stmt.setString(1, domain);
		        stmt.setString(2, level);
		        try (ResultSet rs = stmt.executeQuery()) {
		            while (rs.next()) {
		                Skill competence = new Skill();
		                competence.setId(rs.getInt("idcompetence"));
		                competence.setName(rs.getString("nom"));
		                competence.setDescription(rs.getString("description"));
		                competence.setDomain(rs.getString("domaine"));
		                competence.setLevel(rs.getString("niveau"));
		                competences.add(competence);
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return competences;
		}
		public Skill getSkillById(int id) {
	        Skill skill = null;
	        String sql = "SELECT * FROM competence WHERE idcompetence = ?";
	        try (Connection conn = getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setInt(1, id);
	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                    skill = new Skill();
	                    skill.setId(rs.getInt("idcompetence"));
	                    skill.setName(rs.getString("nom"));
	                    skill.setDescription(rs.getString("description"));
	                    skill.setDomain(rs.getString("domaine"));
	                    skill.setLevel(rs.getString("niveau"));
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return skill;
	    }

	    // Méthode pour mettre à jour une compétence
	    public boolean updateSkill(Skill skill) {
	        String sql = "UPDATE competence SET nom = ?, description = ?, domaine = ?, niveau = ? WHERE idcompetence = ?";
	        try (Connection conn = getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setString(1, skill.getName());
	            stmt.setString(2, skill.getDescription());
	            stmt.setString(3, skill.getDomain());
	            stmt.setString(4, skill.getLevel());
	            stmt.setInt(5, skill.getId());
	            int rowsUpdated = stmt.executeUpdate();
	            return rowsUpdated > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }


}

