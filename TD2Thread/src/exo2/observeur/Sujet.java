package exo2.observeur;

public interface Sujet {
	/**
	 * 
	 * @param observateur
	 */
	void ajouterObservateur(Observateur observateur);
	
	/**
	 * 
	 * @param observateur
	 */
	void retirerObservateur(Observateur observateur);
	
	/**
	 * 
	 */
	void notifierObservateurs();
}
