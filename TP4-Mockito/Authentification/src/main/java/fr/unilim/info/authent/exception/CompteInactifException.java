package fr.unilim.info.authent.exception;

/**
 * Classe d'exception relevée lors de la tentative de connexion à un compte
 * inactif
 *
 */
public class CompteInactifException extends Exception {

	/**
	 * Constructeur
	 * 
	 * @param message
	 *            : Chaîne de caractère liée à l'exception
	 */
	public CompteInactifException(String message) {
		super(message);
	}

}
