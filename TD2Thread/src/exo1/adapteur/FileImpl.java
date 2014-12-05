package exo1.adapteur;

import java.nio.channels.IllegalSelectorException;
import java.util.ArrayList;
import java.util.List;

public class FileImpl<E> implements File<E> {
	private final List<E> liste;

	public FileImpl() {
		this.liste = new ArrayList<E>();
	}

	@Override
	public E tete() {
		if (!this.estVide())
			return liste.get(0);
		return null;
	}

	@Override
	public void insererQueue(E e) {
		liste.add(e);
	}

	@Override
	public E retirerTete() {
		if (this.estVide()) {
			throw new IllegalSelectorException();
		}

		return liste.remove(0);
	}

	@Override
	public int longueur() {
		return liste.size();
	}

	@Override
	public boolean estVide() {
		if (liste.size() == 0)
			return true;
		return false;
	}

}
