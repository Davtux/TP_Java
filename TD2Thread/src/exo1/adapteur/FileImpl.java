package exo1.adapteur;

import java.nio.channels.IllegalSelectorException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe réalisant l'interface {@link File} afin d'être utilisée dans la classe
 * {@link TestFile}
 * 
 * @author Barrat-Leroy
 * 
 */
public class FileImpl<E> implements File<E> {
	private final List<E> liste;

	public FileImpl() {
		this.liste = new ArrayList<E>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo1.adapteur.File#tete()
	 */
	@Override
	public E tete() {
		if (!this.estVide())
			return liste.get(0);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo1.adapteur.File#insererQueue(java.lang.Object)
	 */
	@Override
	public void insererQueue(E e) {
		liste.add(e);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo1.adapteur.File#retirerTete()
	 */
	@Override
	public E retirerTete() {
		if (this.estVide()) {
			throw new IllegalSelectorException();
		}

		return liste.remove(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo1.adapteur.File#longueur()
	 */
	@Override
	public int longueur() {
		return liste.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo1.adapteur.File#estVide()
	 */
	@Override
	public boolean estVide() {
		if (liste.size() == 0)
			return true;
		return false;
	}

}
