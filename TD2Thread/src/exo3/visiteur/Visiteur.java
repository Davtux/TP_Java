package exo3.visiteur;

import exo3.composite.ComposantSyteme;
import exo3.composite.Fichier;
import exo3.composite.Repertoire;

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
	 * 
	 * @param composantSysteme
	 */
	void beforeVisit(ComposantSyteme composantSysteme);
	
	/**
	 * 
	 * @param composantSysteme
	 */
	void afterVisit(ComposantSyteme composantSysteme);
	
}
