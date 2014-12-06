package exo3.composite;

import exo3.visiteur.FichierVisiteur;
import exo3.visiteur.GlobalNameVisiteur;
import exo3.visiteur.HierarchiqueVisiteur;

public class TestComposite {

	/**
	 * Point d'entrée de l'application
	 * @param args : tableau des chaînes de caractère
	 */
	public static void main(String[] args) {
		Repertoire racine = new Repertoire("C:"), windows = new Repertoire(
				"Windows"), system32 = new Repertoire("System32"), temp = new Repertoire(
				"temp");

		system32.addComposantSysteme(new Fichier("adsnt.dll", 12_030));
		system32.addComposantSysteme(new Fichier("advnt.dll", 43_220));

		windows.addComposantSysteme(system32);
		windows.addComposantSysteme(new Fichier("win.ini", 1000));

		temp.addComposantSysteme(new Fichier("test.data", 500));

		racine.addComposantSysteme(windows);
		racine.addComposantSysteme(temp);

		System.out.println(racine);
		
		//Affichage obtenu :
		// Repertoire [nom=C:, listComposantSysteme=[Repertoire [nom=Windows, listComposantSysteme=[Repertoire [nom=System32, listComposantSysteme=[Fichier [nom=adsnt.dll, taille=12030], Fichier [nom=advnt.dll, taille=43220]]], Fichier [nom=win.ini, taille=1000]]], Repertoire [nom=temp, listComposantSysteme=[Fichier [nom=test.data, taille=500]]]]]

		// Affichage obtenu : (après formatage manuel)
		//	Repertoire [nom=C:, listComposantSysteme=[
		//		Repertoire [nom=Windows, listComposantSysteme=[
		//			Repertoire [nom=System32, listComposantSysteme=[
		//				Fichier [nom=adsnt.dll, taille=12030], 
		//				Fichier [nom=advnt.dll, taille=43220]
		//			]], 
		//			Fichier [nom=win.ini, taille=1000]
		//		]],
		//		Repertoire [nom=temp, listComposantSysteme=[
		//			Fichier [nom=test.data, taille=500]
		//		]]
		//	]]
		
		System.out.println("Taille du répertoire C: : " + racine.getTaille());
		
		System.out.println("\nVisiteur de type HierarchiqueVisiteur :");
		racine.acceptVisiteur(new HierarchiqueVisiteur());
		
		System.out.println("\nVisiteur de type GlobalNameVisiteur :");
		racine.acceptVisiteur(new GlobalNameVisiteur());
		
		System.out.println("\nVisiteur de type FichierVisiteur :");
		racine.acceptVisiteur(new FichierVisiteur());

	}

}
