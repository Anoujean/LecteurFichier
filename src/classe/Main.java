package classe;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// Des fichiers: 'par.txt', 'test.txt' & 'testjumeau.txt' sont à disposition à la racine du dossier
		Scanner scanner = new Scanner(System.in);
		LecteurFichier lecteur = null;
		String filepath = null;
		
		while (filepath == null) {
			lecteur = menuTypeLecteur(scanner); 
			filepath = saisieFichier(scanner, lecteur);
		}
		
		menuLecteur(scanner, lecteur, filepath);

	}
	
	public static LecteurFichier menuTypeLecteur(Scanner scanner) {
		System.out.println("Quel sera l'extension de votre fichier? \n 1/ .txt \n 2/ .md \n 3/ .csv");
		int choix = scanner.nextInt();
		LecteurFichier lecteur;
		switch (choix) {
			case 1: {
				lecteur = new LecteurFichierTexte();
				break;
			}
			case 2: {
				lecteur = new LecteurFichierMarkdown();
				break;
			}
			case 3: {
				lecteur = new LecteurFichierCSV();
				break;
			}
			default: {
				lecteur = new LecteurFichierTexte();
				break;
			}
		}
		return lecteur;
	}
	
	public static String saisieFichier(Scanner scanner, LecteurFichier lecteur) {
		System.out.println("\nEcrire le nom de fichier avec l'extension");
		String filepath = scanner.next();
		if (lecteur.verifyFile(filepath) && lecteur.verifyExtension(filepath)) {
			return filepath;
		}
		return null;
	}
	
	public static void menuLecteur(Scanner scanner, LecteurFichier lecteur, String filepath) {
		int choix = 0;
		while(choix >= 0 && choix < 6) {
			System.out.println("Que voulez-vous faire ? \n  1.Lire ce fichier \n  2.Lire ce fichier à l'envers \n  3.Lire le palindrome du fichier \n  4.Comparer à un autre fichier \n  5.Quitter");
			choix = scanner.nextInt();
			switch (choix) {
				case 1:
					lecteur.fileReader(filepath);
					break;
				case 2:
					lecteur.reverseReader(filepath);
					break;
				case 3:
					lecteur.palindromeReader(filepath);
					break;
				case 4: {
					System.out.println("Veuillez saisir un deuxième fichier");
					String filepath2 = null;
					LecteurFichier lecteur2 = null;
					while (filepath2 == null) {
						lecteur2 = menuTypeLecteur(scanner);
						filepath2 = saisieFichier(scanner, lecteur2);
					}
					if (lecteur.compareFiles(filepath, filepath2)) {
						System.out.println("Ces deux fichiers sont identiques");
					}
					else {
						System.out.println("Ces deux fichiers sont différents");
					}
					
					break;
				}
				case 5: {
					System.exit(0);
					break;
				}
				default: {
					break;
				}
			}
		
		}
	}
	
	

}
