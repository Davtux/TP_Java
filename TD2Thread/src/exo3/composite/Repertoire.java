package exo3.composite;

import java.util.ArrayList;
import java.util.List;

public class Repertoire extends ComposantSyteme {
	private final String nom;
	private List<ComposantSyteme> listComposantSysteme;
	
	/**
	 * 
	 * @param nom
	 */
	public Repertoire(String nom) {
		this.nom = nom;
		listComposantSysteme = new ArrayList<ComposantSyteme>();
	}
	
	@Override
	/**
	 * 
	 */
	public String getNom() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return super.getNom();
	}
	
	@Override
	/**
	 * 
	 */
	public int getTaille() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return super.getTaille();
	}
	
	@Override
	/**
	 * 
	 */
	public void addComposantSysteme(ComposantSyteme composant)
			throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		super.addComposantSysteme(composant);
	}
	
	@Override
	/**
	 * 
	 */
	public void removeComposantSysteme(ComposantSyteme composant)
			throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		super.removeComposantSysteme(composant);
	}
	
	@Override
	/**
	 * 
	 */
	public ComposantSyteme getComposantSysteme(int index)
			throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return super.getComposantSysteme(index);
	}

	@Override
	public String toString() {
		return "Repertoire [nom=" + nom + "]";
	}
	
	
}
