package exo3.composite;

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
	
	@Override
	/**
	 * Retourne le nom de ce composant système
	 * @return une chaîne contenant le nom du composant
	 */
	public String getNom() {
		return this.nom;
	}
	
	@Override
	/**
	 * Retourne la taille de ce composant système
	 * @return un entier positif
	 * @throws UnsupportedOperationException
	 */
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
	
	
}
