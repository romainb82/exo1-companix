package Salarie;

import java.util.Date;

public abstract class Salarie {
	
	private String code;
	private String nom;
	private String prenom;
	private Date embauche;

	public Salarie(String code, String nom, String prenom, Date embauche) {
		this.setCode(code);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setEmbauche(embauche);
	}
	
	public Salarie() {
		
	}

	public Date getEmbauche() {
		return embauche;
	}

	public void setEmbauche(Date embauche) {
		this.embauche = embauche;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	

}
