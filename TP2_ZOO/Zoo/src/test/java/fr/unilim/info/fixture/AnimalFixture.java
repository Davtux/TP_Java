package fr.unilim.info.fixture;

import java.util.ArrayList;
import java.util.List;

import fr.unilim.info.Animal;

public class AnimalFixture {
	public static List<Animal> creerListeAnimaux(){
		List<Animal> liste = new ArrayList<Animal>();
		
		liste.add(new Animal("Lion", true, 150.0f)); //Dents, 37.5kg de viande
		liste.add(new Animal("Elephant", false, 2000.0f)); // Pieds, 0kg de viande
		liste.add(new Animal("Tortue", true, 50.0f)); // Dents, 12.5kg de viande
		liste.add(new Animal("Chèvre", false, 10.0f)); // Rien, 0kg de viande
		liste.add(new Animal("Ours", false, 150.0f)); // Rien, 0kg de viande
		liste.add(new Animal("Pingouin", true, 800.0f)); // Dents et pieds, 200kg de viande

		return liste;
	}
}
