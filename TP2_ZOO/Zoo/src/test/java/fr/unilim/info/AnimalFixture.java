package fr.unilim.info;

import java.util.ArrayList;

public class AnimalFixture {
	public static List<Animal> creerListeAnimaux(){
		List<Animal> liste = new ArrayList<Animal>();
		
		liste.add(new Animal("Lion", true, 150.0f));
		liste.add(new Animal("Elephant", false, 2000.0f));
		liste.add(new Animal("Tortue", true, 50.0f));
		liste.add(new Animal("Chèvre", false, 10.0f));
		liste.add(new Animal("Ours", false, 150.0f));
		liste.add(new Animal("Pingouin", true, 800.0f));

		return liste;
	}
}
