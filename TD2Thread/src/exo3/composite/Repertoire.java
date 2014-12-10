package exo3.composite;

import java.util.ArrayList;
import java.util.List;

import exo3.visiteur.Visiteur;

public class Repertoire extends ComposantSyteme {
	private final String nom;
	private List<ComposantSyteme> listComposantSysteme;

	/**
	 * Constructeur
	 * 
	 * @param nom
	 *            : nom de ce répertoire
	 */
	public Repertoire(String nom) {
		this.nom = nom;
		listComposantSysteme = new ArrayList<ComposantSyteme>();
	}

	@Override
	/**
	 * Retourne le nom de ce composant système
	 * @return une chaîne contenant le nom du composant
	 * @throws UnsupportedOperationException
	 */
	public String getNom() {
		return this.nom;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see exo3.composite.ComposantSysteme#getTaille()
	 */
	public int getTaille() {
		int somme = 0;

		// La taille du répertoire est égale à la somme des tailles de ses
		// enfants
		for (ComposantSyteme composant : listComposantSysteme) {
			somme += composant.getTaille();
		}

		return somme;
	}

	@Override
	/**
	 * Ajout d'un composant système à ce répertoire
	 * @param composant
	 * @throws UnsupportedOperationException
	 */
	public void addComposantSysteme(ComposantSyteme composant)
			throws UnsupportedOperationException {
		listComposantSysteme.add(composant);
	}

	@Override
	/**
	 * Enlever un composant système de ce composant
	 * @param composant
	 * @throws UnsupportedOperationException
	 */
	public void removeComposantSysteme(ComposantSyteme composant)
			throws UnsupportedOperationException {
		listComposantSysteme.remove(composant);
	}

	@Override
	/**
	 * Récupère un composant système contenu dans ce composant
	 * @param index l'indice du composant souhaité dans la liste dans laquelle il est contenu
	 * @return l'élément recherché
	 * @throws UnsupportedOperationException
	 */
	public ComposantSyteme getComposantSysteme(int index) {
		return listComposantSysteme.get(index);
	}

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Repertoire [nom=" + nom + ", listComposantSysteme="
				+ listComposantSysteme + "]";
	}

	/**
	 * Méthode déterminant le comportement de ce composant vis à vis d'un visiteur 
	 * @param visiteur : instance d'une classe implémentant {@link Visiteur} 
	 */
	public void acceptVisiteur(Visiteur visiteur) {
		// Avant la visite de ce composant
		visiteur.beforeVisit(this);
		
		// Visite de ce composant
		visiteur.visit(this);
		
		// On propage ensuite la visite vers les composants enfants
		for (ComposantSyteme composant : listComposantSysteme) {
			composant.acceptVisiteur(visiteur);
		}
		
		// Après la visite de ce composant
		visiteur.afterVisit(this);
	}

}
