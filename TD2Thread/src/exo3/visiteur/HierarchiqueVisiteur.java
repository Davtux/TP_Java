package exo3.visiteur;

import exo3.composite.ComposantSyteme;
import exo3.composite.Fichier;
import exo3.composite.Repertoire;

public class HierarchiqueVisiteur implements Visiteur {

	private int niveau;

	/**
	 * Constructeur par défaut
	 */
	public HierarchiqueVisiteur() {
		this.niveau = 0;
	}

	@Override
	/**
	 * 
	 */
	public void visit(Fichier fichier) {
		System.out.println(fichier.getNom());
	}

	@Override
	/**
	 * 
	 */
	public void visit(Repertoire repertoire) {
		System.out.println(repertoire.getNom());
	}

	@Override
	/**
	 * 
	 */
	public void beforeVisit(ComposantSyteme composantSysteme) {
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
	 * 
	 */
	public void afterVisit(ComposantSyteme composantSysteme) {
		this.niveau--;
	}

}
