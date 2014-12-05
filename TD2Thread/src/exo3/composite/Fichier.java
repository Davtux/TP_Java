package exo3.composite;

public class Fichier extends ComposantSyteme {
	private final String nom;
	private final int taille;
	
	/**
	 * 
	 */
	public Fichier(String nom, int taille) {
		this.nom = nom;
		this.taille = taille;
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
	public String toString() {
		return "Fichier [nom=" + nom + ", taille=" + taille + "]";
	}
	
	
}
