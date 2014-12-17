package fr.unilim.info.authent.exception;

/**
 * Classe d'exception relevée lors d'une tentaive d'ajout
 * d'un compte déjà existant
 *
 */
public class CompteDejaInscritException extends Exception {
	/**
	 * Constructeur
	 * @param message : Chaîne de caractère liée à l'exception
	 */
	public CompteDejaInscritException(String message) {
		super(message);
	}

}
