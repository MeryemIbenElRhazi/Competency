package ma.ac.esi.referentielCompetences.model;

public class Profil {

	public String Nom;
	public String 	competences;
	public String niveau ; 
	public int salaire;
	private int idprofil;
	
	public int getIdprofil() {
		return idprofil;
	}


	public void setIdprofil(int idprofil) {
		this.idprofil = idprofil;
	}


	

	public Profil() {
		
	}


	public Profil(String nom, String competences, String niveau, int salaire) {
		
		this.Nom = nom;
		this.competences = competences;
		this.niveau = niveau;
		this.salaire = salaire;
		
	}


	public String getNom() {
		return Nom;
	}


	public void setNom(String nom) {
		Nom = nom;
	}


	public String getCompetences() {
		return competences;
	}


	public void setCompetences(String competences) {
		this.competences = competences;
	}


	public String getNiveau() {
		return niveau;
	}


	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}


	public int getSalaire() {
		return salaire;
	}


	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}
	
	
	
}
