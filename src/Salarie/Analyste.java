package Salarie;

import java.util.ArrayList;
import java.util.Date;

public class Analyste extends Salarie {

	private int nbDeplacementClient;
	private static ArrayList<Analyste> listeAnalyste = new ArrayList<Analyste>();

	public Analyste(String code, String nom, String prenom, Date embauche, int nbDeplacementClient) {
		super(code, nom, prenom, embauche);
		this.nbDeplacementClient = nbDeplacementClient;
	}

	public void addAnalyste(Analyste newAnalyste) {
		listeAnalyste.add(newAnalyste);
	}

	public static void showAnalyste() {
		for (int i = 0; i < listeAnalyste.size(); i++) {
			System.out.println("Code :" + listeAnalyste.get(i).getCode());
			System.out.println("Nom :" + listeAnalyste.get(i).getNom());
			System.out.println("Prenom :" + listeAnalyste.get(i).getPrenom());
			System.out.println("Embauche :" + listeAnalyste.get(i).getEmbauche());
			System.out.println("Nombre Déplacement Client :" + listeAnalyste.get(i).getNbDeplacementClient());
			System.out.println();

		}
	}

	public int getNbDeplacementClient() {
		return nbDeplacementClient;
	}

	public void setNbDeplacementClient(int nbDeplacementClient) {
		this.nbDeplacementClient = nbDeplacementClient;
	}

	public static ArrayList<Analyste> getListeAnalyste() {
		return listeAnalyste;
	}
	
	public boolean compareCode(String code)
	{
		for(int i = 0; i < listeAnalyste.size(); i++) 
		{
			if(code.equals(listeAnalyste.get(i).getCode())){
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
}
