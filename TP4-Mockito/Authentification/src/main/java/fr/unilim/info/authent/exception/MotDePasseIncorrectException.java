package fr.unilim.info.authent.exception;

/**
 * Classe d'exception relevée lors de la saisie d'un mot de passe incorrect
 *
 */
public class MotDePasseIncorrectException extends Exception {

	/**
	 * Constructeur
	 * @param message : Chaîne de caractère liée à l'exception
	 */
	public MotDePasseIncorrectException(String message) {
		super(message);
	}

}
