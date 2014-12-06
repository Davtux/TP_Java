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
public class GlobalNameVisiteur implements Visiteur{
	List<String> chemin;
	
	/**
	 * Constructeur par défaut
	 */
	public GlobalNameVisiteur() {
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
	 * Méthode qui affiche uniquement le nom du répertoire visité
	 * et l'ajoute dans le chemin actuel
	 * @param repertoire : le répertoire visité
	 */
	public void visit(Repertoire repertoire) {
		System.out.println(repertoire.getNom());
		chemin.add(repertoire.getNom());
	}

	@Override
	/**
	 * Affichage du chemin du composant parent à celui visité
	 * @param composantSysteme : le composant visité
	 */
	public void beforeVisit(ComposantSyteme composantSysteme) {
		for(String rep : chemin){
			System.out.print(rep+"\\");
		}
	}

	@Override
	/**
	 * Méthode qui enlève, si le composant en paramètre est un répertoire, le nom
	 * de ce répertoire du chemin actuel
	 */
	public void afterVisit(ComposantSyteme composantSysteme) {
		if(composantSysteme instanceof Repertoire){
			chemin.remove(chemin.size()-1);
		}
	}

}
