package exo3.visiteur;

import exo3.composite.ComposantSyteme;
import exo3.composite.Fichier;
import exo3.composite.Repertoire;

/**
 * 
 * @author Barrat-Leroy
 *
 */
public interface Visiteur {
	/**
	 * Méthode qui visite un fichier
	 * @param fichier : le fichier à visiter
	 */
	void visit(Fichier fichier);
	
	/**
	 * Méthode qui visite un répertoire
	 * @param repertoire : le répertoire à visiter
	 */
	void visit(Repertoire repertoire);
	
	/**
	 * Méthode à appeler avant la visite d'un composant système
	 * @param composantSysteme : le composant visité
	 */
	void beforeVisit(ComposantSyteme composantSysteme);
	
	/**
	 * Méthode à appeler après la visite d'un composant système
	 * @param composantSysteme : le composant visité
	 */
	void afterVisit(ComposantSyteme composantSysteme);
	
}
