package fr.unilim.info;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import fr.unilim.info.fixture.AnimalFixture;

public class ZooTest {

	@Test
	public void testAjoutAnimalNotNull() {
		System.out.println("Début du test : testAjoutAnimalNotNull");

		// Given
		Zoo zoo1 = new Zoo();

		Animal lion = new Animal("Lion", true, 250);

		// When
		zoo1.ajouterAnimal(lion);
		boolean result = zoo1.estVide();

		// Then
		assertEquals(false, result);

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
	public void testRetirerAnimalNotNull() {
		System.out.println("Début du test : testRetirerAnimalNotNull");

		// Given
		Zoo zoo1 = new Zoo();
		Animal animau = new Animal("Lapin", false, 125);
		// When
		zoo1.ajouterAnimal(animau);
		zoo1.retirerAnimal(animau);
		boolean result = zoo1.estVide();

		// Then
		assertEquals(true, result);

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
		Animal animau = new Animal("Lapin", false, 125);
		String resultatAttendu = animau.toString()+"\n";

		// When
		zoo1.ajouterAnimal(animau);
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
		System.out.println("Début du test : testRecupererAnimauxASoignerZooVide");
		// Given
		Zoo zoo1 = new Zoo();

		// When
		List<Animal> result = zoo1.recupererAnimauxASoigner(SoinEnum.DENTS);
		List<Animal> result2 =zoo1.recupererAnimauxASoigner(SoinEnum.PIEDS);
		// Then
		assertTrue(result.isEmpty());
		assertTrue(result2.isEmpty());

	}
	
	@Test
	public void testRecupererAnimauxASoignerZooNonVide() {
		System.out.println("Début du test : testRecupererAnimauxASoignerZooNonVide");
		// Given
		Zoo zoo1 = new Zoo();
		zoo1.setAnimaux(AnimalFixture.creerListeAnimaux());

		// When
		List<Animal> result = zoo1.recupererAnimauxASoigner(SoinEnum.DENTS);
		List<Animal> result2 = zoo1.recupererAnimauxASoigner(SoinEnum.PIEDS);
		
		// Then
		assertFalse(result.isEmpty());
		assertFalse(result2.isEmpty());

	}
	
	
}
