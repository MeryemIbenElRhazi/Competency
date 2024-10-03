package ma.ac.esi.referentielCompetences.model;

public class user {
	public int idusers ;
	public String nom;
	public String prenom;
	public String email;
	private Boolean type;
	public String psswd;
	
	
	
	
	public user(int idusers, String nom, String prenom, String email, Boolean type, String psswd) {
		this.idusers = idusers;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.type = type;
		this.psswd = psswd;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}
 
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Boolean getType() {
		return type;
	}


	public void setType(Boolean type) {
		this.type = type;
	}


	public String getPsswd() {
		return psswd;
	}


	public void setPsswd(String psswd) {
		this.psswd = psswd;
	}

}
