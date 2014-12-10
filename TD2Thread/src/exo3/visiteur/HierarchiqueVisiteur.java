package exo3.visiteur;

import exo3.composite.ComposantSyteme;
import exo3.composite.Fichier;
import exo3.composite.Repertoire;

/**
 * 
 * @author Barrat-Leroy
 *
 */
public class HierarchiqueVisiteur implements Visiteur {
	// Niveau d'indentation
	private int niveau;

	/**
	 * Constructeur par défaut
	 */
	public HierarchiqueVisiteur() {
		this.niveau = 0;
	}

	@Override
	/**
	 * Méthode qui affiche uniquement le nom du fichier visité
	 */
	public void visit(Fichier fichier) {
		System.out.println(fichier.getNom());
	}

	@Override
	/**
	 * Méthode qui affiche uniquement le nom du répertoire visité
	 */
	public void visit(Repertoire repertoire) {
		System.out.println(repertoire.getNom());
	}

	@Override
	/**
	 * Méthode à appeler avant la visite d'un composant système
	 * @param composantSysteme : le composant visité
	 */
	public void beforeVisit(ComposantSyteme composantSysteme) {
		// Grâce à la méthode beforeVisit(), on va pouvoir effectuer une action avant la visite
		// Ici, il s'agit de gérer l'indentation des composants dans la console (affichage d'espaces et incrémentation
		// de la variable contenant le niveau d'indentation)
		
		for(int i = 0; i< niveau-1; i++){
			System.out.print("      ");
		}
		if(niveau != 0){
			System.out.print("\\−−−−−");
		}
		this.niveau++;

	}

	@Override
	/**
	 * Méthode à appeler après la visite d'un composant système
	 * @param composantSysteme : le composant visité
	 */
	public void afterVisit(ComposantSyteme composantSysteme) {
		// Grâce à la méthode afterVisit(), on va pouvoir effectuer une action après la visite
		// Ici, il s'agit simplement de décrémenter la variable contenant le niveau d'indentation
		this.niveau--;
	}

}
