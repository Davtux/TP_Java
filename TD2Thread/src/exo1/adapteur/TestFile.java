package exo1.adapteur;

/**
 * Classe servant à tester la classe FileImpl
 * @author Barrat-Leroy
 *
 */
public class TestFile {
	/**
	 * Point d'entrée de l'application
	 * @param args : tableau de chaînes de caractères passées en ligne de commande
	 */
	public static void main(String[] args) {
		final File<Integer> file = new FileImpl<Integer>();
		file.insererQueue(Integer.valueOf(10));
		file.insererQueue(Integer.valueOf(20));
		file.retirerTete();
		System.out.println(file.tete());
		
		// La classe TestFile joue le rôle de client
		// L'interface File joue le rôle de cible
		// La classe FileImpl joue le rôle d'adaptateur
		// La classe ArrayList joue le rôle de l'adapté
	}
}
