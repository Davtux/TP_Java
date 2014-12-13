package fr.unilim.info;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnimalTest {

	@Test
	public void testEqualsDifferents() {
		System.out.println("Début du test : testEqualsDifferents");

		// Given
		Animal animal1 = new Animal("Lion", true, 250);
		Animal animal2 = new Animal("Kiwi", false, 25);

		// When
		boolean result = animal1.equals(animal2);

		// Then
		assertEquals(false, result);

	}

	@Test
	public void testEqualsMemeObjet() {
		System.out.println("Début du test : testEqualsMemeObjet");

		// Given
		Animal animal1 = new Animal("Lion", true, 250);
		// When
		boolean result = animal1.equals(animal1);

		// Then
		assertEquals(true, result);

	}

	@Test
	public void testEqualsNull() {
		System.out.println("Début du test : testEqualsNull");

		// Given
		Animal animal1 = null;
		Animal animal2 = new Animal("Kiwi", false, 25);

		// When
		boolean result = animal2.equals(animal1);

		// Then
		assertEquals(false, result);

	}

	@Test
	public void testEqualsDifferenceCarnivore() {
		System.out.println("Début du test : testEqualsDifferenceCarnivore");

		// Given
		Animal animal1 = new Animal("Kiwi", true, 25);
		Animal animal2 = new Animal("Kiwi", false, 25);

		// When
		boolean result = animal2.equals(animal1);

		// Then
		assertEquals(false, result);

	}

	@Test
	public void testEqualsDifferencePoids() {
		System.out.println("Début du test : testEqualsDifferencePoids");

		// Given
		Animal animal1 = new Animal("Kiwi", false, 125);
		Animal animal2 = new Animal("Kiwi", false, 25);

		// When
		boolean result = animal2.equals(animal1);

		// Then
		assertEquals(false, result);

	}

	@Test
	public void testEqualsDifferenceEspece() {
		System.out.println("Début du test : testEqualsDifferenceEspece");

		// Given
		Animal animal1 = new Animal("Lion", false, 25);
		Animal animal2 = new Animal("Kiwi", false, 25);

		// When
		boolean result = animal2.equals(animal1);

		// Then
		assertEquals(false, result);

	}

	@Test
	public void testEqualsDifferenceEspeceDeuxiemeNull() {
		System.out
				.println("Début du test : testEqualsDifferenceEspeceDeuxiemeNull");

		// Given
		Animal animal1 = new Animal("", false, 25);
		Animal animal2 = new Animal("Kiwi", false, 25);

		// When
		boolean result = animal2.equals(animal1);

		// Then
		assertEquals(false, result);

	}

	@Test
	public void testEqualsClassesDifferentes() {
		System.out.println("Début du test : testEqualsClassesDifferentes");

		// Given
		Animal animal1 = new Animal("", false, 25);
		// When
		boolean result = animal1.equals("kiwi");

		// Then
		assertEquals(false, result);

	}

	@Test
	public void testEqualsIdentiques() {
		System.out.println("Début du test : testEqualsIdentiques");

		// Given
		Animal animal1 = new Animal("Kiwi", false, 25);
		Animal animal2 = new Animal("Kiwi", false, 25);

		// When
		boolean result = animal2.equals(animal1);

		// Then
		assertEquals(true, result);

	}

	@Test
	public void testEqualsDeuxiemeNull() {
		System.out.println("Début du test : testEqualsDeuxiemeNull");

		// Given
		Animal animal1 = new Animal(null, false, 25);
		Animal animal2 = new Animal("Kiwi", false, 25);

		// When
		boolean result = animal1.equals(animal2);

		// Then
		assertEquals(false, result);

	}

	@Test
	public void testToSring() {
		System.out.println("Début du test : testToSring");

		// Given
		Animal animal1 = new Animal("Lion", false, 25.0f);

		// When
		String result = animal1.toString();

		// Then
		assertEquals("espece=[Lion], isCarnivore=[false], poids=[25.0]", result);

	}

	@Test
	public void testGetEspece() {
		System.out.println("Début du test : testGetEspece");

		// Given
		String nom = "Lion";
		Animal animal1 = new Animal(nom, false, 25.0f);

		// When
		String result = animal1.getEspece();

		// Then
		assertTrue(nom==result);
	}
	
	@Test
	public void testSetEspece() {
		System.out.println("Début du test : testSetEspece");

		// Given
		String nom = "Lion";
		Animal animal1 = new Animal("Girafe", false, 25.0f);

		// When
		animal1.setEspece(nom);

		// Then
		assertTrue(nom==animal1.getEspece());
	}
	
	@Test
	public void testIsCarnivore(){
		System.out.println("Début du test : testIsCarnivore");

		// Given
		Animal animal1 = new Animal("Girafe", false, 25.0f);

		// When
		boolean resultat = animal1.isCarnivore();

		// Then
		assertFalse(resultat);
	}
	
	@Test
	public void testSetCarnivore(){
		System.out.println("Début du test : testSetCarnivore");

		// Given
		Animal animal1 = new Animal("Girafe", false, 25.0f);

		// When
		animal1.setCarnivore(true);

		// Then
		assertTrue(animal1.isCarnivore());
	}
	
	@Test
	public void testGetPoids(){
		System.out.println("Début du test : testGetPoids");

		// Given
		Animal animal1 = new Animal("Girafe", false, 25.0f);

		// When
		float resultat = animal1.getPoids();

		// Then
		assertTrue(resultat == 25.0f);
	}
	
	@Test
	public void testSetPoids(){
		System.out.println("Début du test : testSetPoids");

		// Given
		Animal animal1 = new Animal("Girafe", false, 25.0f);

		// When
		animal1.setPoids(50.0f);

		// Then
		assertTrue(animal1.getPoids() == 50.0f);
	}
	
	@Test
	public void testNecessiteSoinDentsVrai(){
		System.out.println("Début du test : testNecessiteSoinDentsVrai");

		// Given
		Animal animal1 = new Animal("Dinosaure", true, 2500.0f);

		// When
		boolean resultat = animal1.necessiteSoin(SoinEnum.DENTS);

		// Then
		assertTrue(resultat);
	}
	
	@Test
	public void testNecessiteSoinDentsFaux(){
		System.out.println("Début du test : testNecessiteSoinDentsFaux");

		// Given
		Animal animal1 = new Animal("Poule", false, 1.0f);

		// When
		boolean resultat = animal1.necessiteSoin(SoinEnum.DENTS);

		// Then
		assertFalse(resultat);
	}
	
	@Test
	public void testNecessiteSoinPiedsVrai(){
		System.out.println("Début du test : testNecessiteSoinPiedsVrai");

		// Given
		Animal animal1 = new Animal("Dinosaure", false, 2500.0f);

		// When
		boolean resultat = animal1.necessiteSoin(SoinEnum.PIEDS);

		// Then
		assertTrue(resultat);
	}
	
	@Test
	public void testNecessiteSoinPiedsFaux(){
		System.out.println("Début du test : testNecessiteSoinPiedsFaux");

		// Given
		Animal animal1 = new Animal("Poule", true, 100.0f);

		// When
		boolean resultat = animal1.necessiteSoin(SoinEnum.PIEDS);

		// Then
		assertFalse(resultat);
	}
	
	@Test
	public void testCalculerViandeHebdoCarnivore(){
		System.out.println("Début du test : testCalculerViandeHebdoCarnivore");

		// Given
		Animal animal1 = new Animal("Poule", true, 100.0f);

		// When
		float resultat = animal1.calculerViandeHebdo();

		// Then
		assertTrue(resultat == 25.0f);
	}
	
	@Test
	public void testCalculerViandeHebdoNonCarnivore(){
		System.out.println("Début du test : testCalculerViandeHebdoNonCarnivore");

		// Given
		Animal animal1 = new Animal("Poule", false, 1.23456f);

		// When
		float resultat = animal1.calculerViandeHebdo();

		// Then
		assertTrue(resultat == 0.0f);
	}
}
