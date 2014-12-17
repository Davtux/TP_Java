package fr.unilim.info.authent.exception;

/**
 * Classe d'exception relevée lors d'une tentative d'accès
 * à un compte qui n'existe pas
 *
 */
public class CompteInexistantException extends Exception {
	/**
	 * Constructeur
	 * @param message : Chaîne de caractère liée à l'exception
	 */
	public CompteInexistantException(String message) {
		super(message);
	}

}
