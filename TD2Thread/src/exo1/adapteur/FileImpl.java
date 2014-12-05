package exo1.adapteur;

import java.util.ArrayList;
import java.util.List;

public class FileImpl<E> implements File<E> {
	private final List<E> liste;
	
	public FileImpl() {
		this.liste = new ArrayList<E>();
	}

	@Override
	public E tete() {
		if(!this.estVide())
			return this.get(0);
		return null;
	}

	@Override
	public void insererQueue(E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E retirerTete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int longueur() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean estVide() {
		// TODO Auto-generated method stub
		return false;
	}

}
