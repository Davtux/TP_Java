package exo1.adapteur;

/**
 * Interface décrivant le comportement attendu pour une file
 * @author Barrat-Leroy
 *
 */
public interface File<E> {
	/**
	 * Méthode retournant l'élément en tête de cette file
	 * @return l'élément en tête de file
	 */
	E tete();
	
	/**
	 * Méthode insérant un élément en queue de cette file
	 * @param e l'élément à ajouter
	 */
	void insererQueue(E e);
	
	/**
	 * Méthode retirant l'élément en tête de cette file
	 * @return l'élément rétiré de cette file
	 */
	E retirerTete();
	
	/**
	 * Fonction qui calcule la longueur de cette file
	 * @return un entier positif
	 */
	int longueur();
	
	/**
	 * Fonction testant si cette file est vide
	 * @return un booléen valant <code>true</code> si cette file est vide
	 */
	boolean estVide();
}
