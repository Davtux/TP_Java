package exo3.composite;

import exo3.visiteur.Visiteur;

public class Fichier extends ComposantSyteme {
	private final String nom;
	private final int taille;

	/**
	 * Constructeur
	 */
	public Fichier(String nom, int taille) {
		this.nom = nom;
		this.taille = taille;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo3.composite.ComposantSyteme#getNom()
	 */
	@Override
	public String getNom() {
		return this.nom;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo3.composite.ComposantSyteme#getTaille()
	 */
	@Override
	public int getTaille() throws UnsupportedOperationException {
		return this.taille;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Fichier [nom=" + nom + ", taille=" + taille + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * exo3.composite.ComposantSyteme#acceptVisiteur(exo3.visiteur.Visiteur)
	 */
	@Override
	public void acceptVisiteur(Visiteur visiteur) {
		// Avant la visite de ce composant
		visiteur.beforeVisit(this);

		// Visite de ce composant
		visiteur.visit(this);

		// Après la visite de ce composant
		visiteur.afterVisit(this);

	}

}
