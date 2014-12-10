package exo2.observeur;

public interface Observateur {
	/**
	 * Est appellé en cas de modification de donnée.
	 * 
	 * @param donnee
	 *            la donnée modifiée
	 */
	void modifier(Donnee donnee);
}
