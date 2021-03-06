package exo3.composite;

import exo3.visiteur.Visiteur;

public abstract class ComposantSyteme {
	/**
	 * Retourne le nom de ce composant système
	 * 
	 * @return une chaîne contenant le nom du composant
	 * @throws UnsupportedOperationException
	 */
	public String getNom() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * Retourne la taille de ce composant système
	 * 
	 * @return un entier positif
	 * @throws UnsupportedOperationException
	 */
	public int getTaille() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * Ajout d'un composant système à ce composant
	 * 
	 * @param composant
	 * @throws UnsupportedOperationException
	 */
	public void addComposantSysteme(ComposantSyteme composant)
			throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * Enlever un composant système de ce composant
	 * 
	 * @param composant
	 * @throws UnsupportedOperationException
	 */
	public void removeComposantSysteme(ComposantSyteme composant)
			throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * Récupère un composant système contenu dans ce composant
	 * 
	 * @param index
	 *            l'indice du composant souhaité dans la liste dans laquelle il
	 *            est contenu
	 * @return l'élément recherché
	 * @throws UnsupportedOperationException
	 */
	public ComposantSyteme getComposantSysteme(int index)
			throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * Méthode déterminant le comportement de ce composant vis à vis d'un visiteur 
	 * @param visiteur : instance d'une classe implémentant {@link Visiteur} 
	 * @throws UnsupportedOperationException
	 */
	public void acceptVisiteur(Visiteur visiteur)
			throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
}
