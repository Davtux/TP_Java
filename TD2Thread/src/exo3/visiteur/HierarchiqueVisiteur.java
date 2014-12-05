package exo3.visiteur;

import exo3.composite.ComposantSyteme;
import exo3.composite.Fichier;
import exo3.composite.Repertoire;

public class HierarchiqueVisiteur implements Visiteur {
	/**
	 * Constructeur par défaut
	 */
	public HierarchiqueVisiteur() {
	}

	@Override
	/**
	 * 
	 */
	public void visit(Fichier fichier) {
		System.out.println("Composant visité : "+fichier.getNom());
	}

	@Override
	/**
	 * 
	 */
	public void visit(Repertoire repertoire) {
		System.out.println("Composant visité : "+repertoire.getNom());		
	}

	@Override
	/**
	 * 
	 */
	public void beforeVisit(ComposantSyteme composantSysteme) {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * 
	 */
	public void afterVisit(ComposantSyteme composantSysteme) {
		// TODO Auto-generated method stub
		
	}

}
