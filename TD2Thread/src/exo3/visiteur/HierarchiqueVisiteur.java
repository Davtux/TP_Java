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

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo3.visiteur.Visiteur#visit(exo3.composite.Fichier)
	 */
	@Override
	public void visit(Fichier fichier) {
		System.out.println(fichier.getNom());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo3.visiteur.Visiteur#visit(exo3.composite.Repertoire)
	 */
	@Override
	public void visit(Repertoire repertoire) {
		System.out.println(repertoire.getNom());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo3.visiteur.Visiteur#beforeVisit(exo3.composite.ComposantSyteme)
	 */
	@Override
	public void beforeVisit(ComposantSyteme composantSysteme) {
		// Grâce à la méthode beforeVisit(), on va pouvoir effectuer une action
		// avant la visite
		// Ici, il s'agit de gérer l'indentation des composants dans la console
		// (affichage d'espaces et incrémentation
		// de la variable contenant le niveau d'indentation)

		for (int i = 0; i < niveau - 1; i++) {
			System.out.print("      ");
		}
		if (niveau != 0) {
			System.out.print("\\−−−−−");
		}
		this.niveau++;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo3.visiteur.Visiteur#afterVisit(exo3.composite.ComposantSyteme)
	 */
	@Override
	public void afterVisit(ComposantSyteme composantSysteme) {
		// Grâce à la méthode afterVisit(), on va pouvoir effectuer une action
		// après la visite
		// Ici, il s'agit simplement de décrémenter la variable contenant le
		// niveau d'indentation
		this.niveau--;
	}

}
