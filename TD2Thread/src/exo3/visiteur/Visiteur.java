package exo3.visiteur;

import exo3.composite.ComposantSyteme;
import exo3.composite.Fichier;
import exo3.composite.Repertoire;

public interface Visiteur {
	/**
	 * 
	 * @param fichier
	 */
	void visit(Fichier fichier);
	
	/**
	 * 
	 * @param repertoire
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
