package exo3.visiteur;

import java.util.ArrayList;
import java.util.List;

import exo3.composite.ComposantSyteme;
import exo3.composite.Fichier;
import exo3.composite.Repertoire;

/**
 * 
 * @author Barrat-Leroy
 * 
 */
public class FichierVisiteur implements Visiteur {
	List<String> chemin;

	/**
	 * Constructeur par défaut
	 */
	public FichierVisiteur() {
		chemin = new ArrayList<String>();
	}

	@Override
	/**
	 * Méthode qui affiche uniquement le nom du fichier visité
	 */
	public void visit(Fichier fichier) {
		System.out.println(fichier.getNom());
	}

	@Override
	/**
	 * Méthode ajoute le répertoire visité dans le chemin actuel
	 * @param repertoire : le répertoire visité
	 */
	public void visit(Repertoire repertoire) {
		chemin.add(repertoire.getNom());
	}

	@Override
	/**
	 * Affichage du chemin du composant parent à celui visité
	 * @param composantSysteme : le composant visité
	 */
	public void beforeVisit(ComposantSyteme composantSysteme) {
		if (composantSysteme instanceof Fichier) {

			for (String rep : chemin) {
				System.out.print(rep + "\\");
			}
		}
	}

	@Override
	/**
	 * Méthode qui enlève, si le composant en paramètre est un répertoire, le nom
	 * de ce répertoire du chemin actuel
	 */
	public void afterVisit(ComposantSyteme composantSysteme) {
		if (composantSysteme instanceof Repertoire) {
			chemin.remove(chemin.size() - 1);
		}
	}

}
