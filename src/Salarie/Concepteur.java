package Salarie;

import java.util.Date;
import java.util.ArrayList;

public class Concepteur extends Salarie {

	private int nbAnneeDev;

	private static ArrayList<Concepteur> listeConcepteur = new ArrayList<Concepteur>();

	public Concepteur(String code, String nom, String prenom, Date embauche, int nbAnneeDev) {
		super(code, nom, prenom, embauche);
		this.nbAnneeDev = nbAnneeDev;
	}

	public Concepteur() {
		super();
	}

	public void addConcepteur(Concepteur newConcepteur) {
		Concepteur.listeConcepteur.add(newConcepteur);
	}

	public static void showConcepteur() {
		for (int i = 0; i < listeConcepteur.size(); i++) {
			System.out.println("Code : " + listeConcepteur.get(i).getCode());
			System.out.println("Nom :" + listeConcepteur.get(i).getNom());
			System.out.println("Prenom :" + listeConcepteur.get(i).getPrenom());
			System.out.println("Embauche :" + listeConcepteur.get(i).getEmbauche());
			System.out.println("Nombre Année de Dev :" + listeConcepteur.get(i).getNbAnneeDev());
			System.out.println();

		}
	}

	public int getNbAnneeDev() {
		return nbAnneeDev;
	}

	public void setNbAnneeDev(int nbAnneeDev) {
		this.nbAnneeDev = nbAnneeDev;
	}
	
	public static ArrayList<Concepteur> getListeConcepteur() {
		return listeConcepteur;
	}
	
	public boolean compareCode(String code)
	{
		for(int i = 0; i < listeConcepteur.size(); i++) 
		{
			if(code.equals(listeConcepteur.get(i).getCode())){
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
}
