package exo1.adapteur;

import java.nio.channels.IllegalSelectorException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe réalisant l'interface {@link File} afin d'être
 * utilisée dans la classe {@link TestFile}
 * @author Barrat-Leroy
 * 
 */
public class FileImpl<E> implements File<E> {
	private final List<E> liste;

	public FileImpl() {
		this.liste = new ArrayList<E>();
	}

	@Override
	/**
	 * Méthode retournant l'élément en tête de file
	 * @return l'objet en tête de file
	 */
	public E tete() {
		if (!this.estVide())
			return liste.get(0);
		return null;
	}

	@Override
	/**
	 * Méthode insérant un élément en queue de cette file
	 * @param e l'élément à ajouter
	 */
	public void insererQueue(E e) {
		liste.add(e);
	}

	@Override
	/**
	 * Méthode retirant l'élément en tête de cette file
	 * @return l'élément rétiré de cette file
	 */
	public E retirerTete() {
		if (this.estVide()) {
			throw new IllegalSelectorException();
		}

		return liste.remove(0);
	}

	@Override
	/**
	 * Fonction qui calcule la longueur de cette file
	 * @return un entier positif
	 */
	public int longueur() {
		return liste.size();
	}

	@Override
	/**
	 * Fonction testant si cette file est vide
	 * @return un booléen valant <code>true</code> si cette file est vide
	 */
	public boolean estVide() {
		if (liste.size() == 0)
			return true;
		return false;
	}

}
