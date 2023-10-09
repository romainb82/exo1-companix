package Salarie;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int menu = 92;

		Scanner sc = new Scanner(System.in);

		while (menu != 0) {
			System.out.println("==================MENU==================");
			System.out.println();
			System.out.println("1: Ajouter un concepteur");

			System.out.println("2: Supprimer un concepteur");

			System.out.println("3: Lister les concepteurs");

			System.out.println("4: Ajouter un analyste");

			System.out.println("5: Supprimer un analyste");

			System.out.println("6: Lister tous les employés");

			System.out.println("0: Fin du programme");
			menu = sc.nextInt();

			if (menu == 1) {

				System.out
						.println("Saisir le code, nom, prénom, date d’embauche et nombre d’année de développement : ");

				String concepteur = sc.next();

				String[] parts = concepteur.split("-");

				Date dateEmbaucheFormate = null;
				String dateEmbauche = parts[3];
				if ((dateEmbauche != null) || !dateEmbauche.matches("\\d{4}-[01]\\d-[0-3]\\d")) {
					try {
						dateEmbaucheFormate = new SimpleDateFormat("dd/MM/yyyy").parse(dateEmbauche);
					} catch (ParseException e) {
						e.printStackTrace();
					}

					if (!(parts[1].matches("[0-9]+")) || !(parts[2].matches("[0-9]+"))) {

						if ((parts[1] != null) || (parts[2] != null) || (parts[4] != null)) {
							addSalaries("concepteur", parts[0], parts[1], parts[2], dateEmbaucheFormate,
									Integer.parseInt(parts[4]), null);
						} else {
							System.out.println("Tous les champs doivent être renseignés");
						}
					} else {
						System.out.println("Le nom ou le prénom ne peuvent pas contenir de chiffre");
					}
				} else {
					System.out.println("Mauvaise date renseigné");
				}

			} else if (menu == 2) {

				System.out.println("Saisir le code d'un des salariés : ");
				String codeSalarie = sc.next();

				deleteSalaries("concepteur", codeSalarie);

			} else if (menu == 3) {
				Concepteur.showConcepteur();

			} else if (menu == 4) {
				System.out.println("Saisir le code, nom, prénom, date d’embauche et nombre de déplacement client : ");
				String analyste = sc.next();

				String[] parts = analyste.split("-");

				Date dateEmbaucheFormate = null;
				String dateEmbauche = parts[3];
				if ((dateEmbauche != null) || !(dateEmbauche.matches("\\d{4}-\\d{2}-\\d{2}"))) {
					try {
						dateEmbaucheFormate = new SimpleDateFormat("dd/MM/yyyy").parse(dateEmbauche);
					} catch (ParseException e) {
						e.printStackTrace();
					}

					if (!(parts[1].matches("[0-9]+")) || !(parts[2].matches("[0-9]+"))) {

						if ((parts[1] != null) || (parts[2] != null) || (parts[4] != null)) {
							addSalaries("analyste", parts[0], parts[1], parts[2], dateEmbaucheFormate, null,
									Integer.parseInt(parts[4]));

						} else {
							System.out.println("Tous les champs doivent être renseignés");
						}
					} else {
						System.out.println("Le nom ou le prénom ne peuvent pas contenir de chiffre");
					}
				} else {
					System.out.println("Mauvaise date renseigné");
				}

			} else if (menu == 5) {

				System.out.println("Saisir le code d'un des salariés : ");
				String codeSalarie = sc.next();

				deleteSalaries("analyste", codeSalarie);

			} else if (menu == 6) {

				HashMap<Object, Object> listeSalaries = new HashMap<>();
				listeSalaries.put("CONCEPTEUR", Concepteur.getListeConcepteur());
				listeSalaries.put("ANALYSTE", Analyste.getListeAnalyste());

				for (Object key : listeSalaries.keySet()) {
					ArrayList<?> employees = (ArrayList<?>) listeSalaries.get(key);

					if (key.equals("CONCEPTEUR")) {
						System.out.println(key);
						Collections.sort((ArrayList<Concepteur>) employees, Comparator.comparing(Concepteur::getNom));

						Concepteur.showConcepteur();
						System.out.println();

					} else if (key.equals("ANALYSTE")) {
						System.out.println(key);
						Collections.sort((ArrayList<Analyste>) employees, Comparator.comparing(Analyste::getNom));

						Analyste.showAnalyste();
						System.out.println();

					}
				}

			}
		}
	}

	public static void addSalaries(String typeSalarie, String code, String nom, String prenom, Date embauche,
			Integer nbAnneeDev, Integer nbDeplacementClient) {
		if (typeSalarie.equals("concepteur")) {
			Concepteur ajoutConcepteur = new Concepteur(code, nom, prenom, embauche, nbAnneeDev);
			
			
			if (ajoutConcepteur.compareCode(code)) {
				System.out.println("Erreur, code déjà attribué!");
			} else {
				ajoutConcepteur.addConcepteur(ajoutConcepteur);
			}
		} else if (typeSalarie.equals("analyste")) {
			Analyste ajoutAnalyste = new Analyste(code, nom, prenom, embauche, nbDeplacementClient);

			if (ajoutAnalyste.compareCode(code)) {
				System.out.println("Erreur, code déjà attribué!");

			} else {
				ajoutAnalyste.addAnalyste(ajoutAnalyste);
			}

		}
	}

	public static void deleteSalaries(String typeSalarie, String codeSalarie) {
		if (typeSalarie.equals("concepteur")) {

			if (codeSalarie.matches("[0-9]+")) {
				ArrayList<Concepteur> listeConcepteur = Concepteur.getListeConcepteur();

				for (int i = 0; i < listeConcepteur.size(); i++) {
					if (codeSalarie.equals(listeConcepteur.get(i).getCode())) {
						listeConcepteur.remove(i);
						System.out.println("Salarié " + codeSalarie + " supprimé");
					} else {
						System.out.println("Le code saisie n'existe pas");
					}
				}
			} else {
				System.out.println("le code salarie ne doit pas contenir de lettre");
			}

		} else if (typeSalarie.equals("analyste")) {
			if (codeSalarie.matches("[0-9]+")) {

				ArrayList<Analyste> listeAnalyste = Analyste.getListeAnalyste();

				for (int i = 0; i < listeAnalyste.size(); i++) {
					if (codeSalarie.equals(listeAnalyste.get(i).getCode())) {
						listeAnalyste.remove(i);
						System.out.println("Salarié " + codeSalarie + " supprimé");
					} else {
						System.out.println("Le code saisie n'existe pas");
					}
				}
			} else {
				System.out.println("le code salarie ne doit pas contenir de lettre");
			}

		}
	}

}
