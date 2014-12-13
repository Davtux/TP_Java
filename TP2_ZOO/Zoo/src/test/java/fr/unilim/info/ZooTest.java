package fr.unilim.info;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import fr.unilim.info.fixture.AnimalFixture;

public class ZooTest {

	@Test
	public void testEstVideZooVide() {
		// Given
		Zoo zoo1 = new Zoo();

		// When
		boolean resultat = zoo1.estVide();

		// Then
		assertTrue(resultat);
	}

	@Test
	public void testEstVideZooNonVide() {
		// Given
		Zoo zoo1 = new Zoo();
		zoo1.setAnimaux(AnimalFixture.creerListeAnimaux());

		// When
		boolean resultat = zoo1.estVide();

		// Then
		assertFalse(resultat);
	}

	@Test
	public void testAjouterAnimalNonNull() {
		System.out.println("Début du test : testAjouterAnimalNonNull");

		// Given
		Zoo zoo1 = new Zoo();

		Animal lion = new Animal("Lion", true, 250);

		// When
		zoo1.ajouterAnimal(lion);
		boolean result = zoo1.estVide();
		List<Animal> liste = zoo1.getAnimaux();

		// Then
		assertEquals(false, result);
		assertEquals(liste.get(0), lion);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testAjoutAnimalNull() {
		System.out.println("Début du test : testAjoutAnimalNull");

		// Given
		Zoo zoo1 = new Zoo();

		// When
		zoo1.ajouterAnimal(null);

		// Then
		fail();

	}

	@Test(expected = IllegalArgumentException.class)
	public void testRetirerAnimalNull() {
		System.out.println("Début du test : testRetirerAnimalNull");

		// Given
		Zoo zoo1 = new Zoo();
		zoo1.setAnimaux(AnimalFixture.creerListeAnimaux());

		// When
		zoo1.retirerAnimal(null);

		// Then
		fail();

	}

	@Test
	public void testRetirerAnimalNotNullFinalementVide() {
		System.out
				.println("Début du test : testRetirerAnimalNotNullFinalementVide");

		// Given
		Zoo zoo1 = new Zoo();
		Animal animal = new Animal("Lapin", false, 125);
		// When
		zoo1.ajouterAnimal(animal);
		zoo1.retirerAnimal(animal);
		boolean result = zoo1.estVide();

		// Then
		assertEquals(true, result);

	}

	@Test
	public void testRetirerAnimalNotNullFinalementNonVide() {
		System.out
				.println("Début du test : testRetirerAnimalNotNullFinalementNonVide");

		// Given
		Zoo zoo1 = new Zoo();
		Animal animal = new Animal("Lapin", false, 125), animal2 = new Animal(
				"Lapin", false, 125);

		// When
		zoo1.ajouterAnimal(animal);
		zoo1.ajouterAnimal(animal2);
		zoo1.retirerAnimal(animal);

		// Then
		assertTrue(zoo1.getAnimaux().get(0) == animal2);

	}

	@Test
	public void testToStringEmptyZoo() {
		System.out.println("Début du test : testToStringEmptyZoo");

		// Given
		Zoo zoo1 = new Zoo();
		// When
		String result = zoo1.toString();
		// Then
		assertEquals("Ce zoo est vide", result);

	}

	@Test
	public void testToStringNotEmptyZoo() {
		System.out.println("Début du test : testToStringNotEmptyZoo");
		// Given
		Zoo zoo1 = new Zoo();
		Animal animal = new Animal("Lapin", false, 125);
		String resultatAttendu = animal.toString() + "\n";

		// When
		zoo1.ajouterAnimal(animal);
		String result = zoo1.toString();
		// Then
		assertEquals(resultatAttendu, result);

	}

	@Test
	public void testCalculerViandeHebdoZooVide() {
		System.out.println("Début du test : testCalculerViandeHebdoZooVide");
		// Given
		Zoo zoo1 = new Zoo();

		// When
		float result = zoo1.calculerViandeHebdo();

		// Then
		assertTrue(0.0 == result);

	}

	@Test
	public void testCalculerViandeHebdoZooNonVide() {
		System.out.println("Début du test : testCalculerViandeHebdoZooNonVide");
		// Given
		Zoo zoo1 = new Zoo();
		zoo1.setAnimaux(AnimalFixture.creerListeAnimaux());

		// When
		float result = zoo1.calculerViandeHebdo();

		// Then
		assertTrue(250.0 == result);

	}

	@Test
	public void testRecupererAnimauxASoignerZooVide() {
		System.out
				.println("Début du test : testRecupererAnimauxASoignerZooVide");
		// Given
		Zoo zoo1 = new Zoo();

		// When
		List<Animal> result = zoo1.recupererAnimauxASoigner(SoinEnum.DENTS);
		List<Animal> result2 = zoo1.recupererAnimauxASoigner(SoinEnum.PIEDS);
		// Then
		assertTrue(result.isEmpty());
		assertTrue(result2.isEmpty());

	}

	@Test
	public void testRecupererAnimauxASoignerDentsZooNonVide() {
		System.out
				.println("Début du test : testRecupererAnimauxASoignerDentsZooNonVide");
		// Given
		Zoo zoo1 = new Zoo();
		List<Animal> listeAnimaux = AnimalFixture.creerListeAnimaux();
		zoo1.setAnimaux(listeAnimaux);

		// When
		List<Animal> result = zoo1.recupererAnimauxASoigner(SoinEnum.DENTS);

		// Then
		assertFalse(result.isEmpty());
		assertTrue(result.contains(listeAnimaux.get(0)));
		assertTrue(result.contains(listeAnimaux.get(2)));
		assertTrue(result.contains(listeAnimaux.get(5)));

		assertFalse(result.contains(listeAnimaux.get(1)));
		assertFalse(result.contains(listeAnimaux.get(3)));
		assertFalse(result.contains(listeAnimaux.get(4)));

	}

	@Test
	public void testRecupererAnimauxASoignerPiedsZooNonVide() {
		System.out
				.println("Début du test : testRecupererAnimauxASoignerPiedsZooNonVide");
		// Given
		Zoo zoo1 = new Zoo();
		List<Animal> listeAnimaux = AnimalFixture.creerListeAnimaux();
		zoo1.setAnimaux(listeAnimaux);

		// When
		List<Animal> result = zoo1.recupererAnimauxASoigner(SoinEnum.PIEDS);

		// Then
		assertFalse(result.isEmpty());
		assertTrue(result.contains(listeAnimaux.get(1)));
		assertTrue(result.contains(listeAnimaux.get(5)));

		assertFalse(result.contains(listeAnimaux.get(0)));
		assertFalse(result.contains(listeAnimaux.get(2)));
		assertFalse(result.contains(listeAnimaux.get(3)));
		assertFalse(result.contains(listeAnimaux.get(4)));

	}

}
