package fr.unilim.info;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant un zoo contenant une {@link ArrayList} d'instances de la
 * classe {@link Animal}
 *
 */
public class Zoo {
	List<Animal> animaux;

	/**
	 * Constructeur par défaut
	 */
	public Zoo() {
		animaux = new ArrayList<Animal>();
	}

	/**
	 * Méthode ajoutant un animal dans ce zoo
	 * 
	 * @param animal
	 *            : l'animal à ajouter Une exception de type
	 *            {@link IllegalArgumentException} est levée si null est passé
	 *            en paramètre
	 */
	public void ajouterAnimal(Animal animal) {
		if (animal == null)
			throw new IllegalArgumentException(
					"L'argument passé à la méthode ajouterAnimal ne doit pas être nul");
		animaux.add(animal);
	}

	/**
	 * Méthode permettant de retirer l'animal passé en paramètre de ce zoo Une
	 * exception de type {@link IllegalArgumentException} est levée si l'animal
	 * n'appartenait pas à ce zoo
	 */
	public void retirerAnimal(Animal animal) {
		boolean existe = animaux.remove(animal);
		if (existe == false) {
			throw new IllegalArgumentException(
					"L'animal n'existe pas dans ce zoo");
		}
	}

	/**
	 * Méthode testant si ce zoo est vide ou non
	 * 
	 * @return <code>true</code> si ce zoo est vide, <code>false</code> sinon
	 */
	public boolean estVide() {
		return animaux.isEmpty();
	}

	/**
	 * Méthode transformant cet objet en une chaîne de type {@link String}
	 */
	@Override
	public String toString() {
		if (this.estVide())
			return "Ce zoo est vide";

		String res = "";
		for (Animal a : animaux) {
			res += a.toString() + "\n";
		}
		return res;
	}

	/**
	 * Méthode calculant la quantité de viande nécessaire
	 * dans ce zoo et la retournant
	 */
	public float calculerViandeHebdo() {
		float res = 0.0f;

		for (Animal a : animaux) {
			res += a.calculerViandeHebdo();
		}

		return res;
	}

	/**
	 * Méthode renvoyant la liste d'animaux de ce zoo
	 * nécessitant le type de soins passé en paramètre
	 * @return une {@link ArrayList} d'instances de la
	 * classe {@link Animal}
	 */
	public List<Animal> recupererAnimauxASoigner(SoinEnum typeSoin) {
		List<Animal> listeRetour = new ArrayList<Animal>();

		for (Animal a : animaux) {
			if (a.necessiteSoin(typeSoin)) {
				listeRetour.add(a);
			}
		}

		return listeRetour;
	}

	/**
	 * Getter du champ animaux
	 * @return
	 */
	public List<Animal> getAnimaux() {
		return animaux;
	}
	
	
	/**
	 * Setter du champ animaux
	 * @param animaux
	 */
	public void setAnimaux(List<Animal> animaux) {
		this.animaux = animaux;
	}

}
