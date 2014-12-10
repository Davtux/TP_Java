package exo2.observeur;

public interface Sujet {
	/**
	 * Procédure permettant d'ajouter un Observateur au capteur
	 * 
	 * @param observateur
	 *            se faisant ajouter
	 */
	void ajouterObservateur(Observateur observateur);

	/**
	 * Procédure permettant de suprimmer un Observateur au capteur.
	 * 
	 * @param observateur
	 *            se faisant suprimmer
	 */
	void retirerObservateur(Observateur observateur);

	/**
	 * Procédure permettant de notifier les observateurs
	 */
	void notifierObservateurs();
}
