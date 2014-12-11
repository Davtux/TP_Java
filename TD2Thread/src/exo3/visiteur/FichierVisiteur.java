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

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo3.visiteur.Visiteur#visit(exo3.composite.Fichier)
	 */
	@Override
	public void visit(Fichier fichier) {
		System.out.println(fichier.getNom());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo3.visiteur.Visiteur#visit(exo3.composite.Repertoire)
	 */
	@Override
	public void visit(Repertoire repertoire) {
		chemin.add(repertoire.getNom());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo3.visiteur.Visiteur#beforeVisit(exo3.composite.ComposantSyteme)
	 */
	@Override
	public void beforeVisit(ComposantSyteme composantSysteme) {
		if (composantSysteme instanceof Fichier) {

			for (String rep : chemin) {
				System.out.print(rep + "\\");
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo3.visiteur.Visiteur#afterVisit(exo3.composite.ComposantSyteme)
	 */
	@Override
	public void afterVisit(ComposantSyteme composantSysteme) {
		if (composantSysteme instanceof Repertoire) {
			chemin.remove(chemin.size() - 1);
		}
	}

}
