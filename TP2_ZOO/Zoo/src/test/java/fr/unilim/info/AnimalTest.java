package fr.unilim.info;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnimalTest {

	@Test
	public void testIsNotEquals() {
		System.out.println("Début du test : test testIsNotEquals");

		// Given
		Animal animal1 = new Animal("Lion", true, 250);
		Animal animal2 = new Animal("Kiwi", false, 25);

		// When
		boolean result = animal1.equals(animal2);

		// Then
		assertEquals(false, result);

	}

	@Test
	public void testIsEquals() {
		System.out.println("Début du test : test testIsEquals");

		// Given
		Animal animal1 = new Animal("Lion", true, 250);
		// When
		boolean result = animal1.equals(animal1);

		// Then
		assertEquals(true, result);

	}

	@Test
	public void testIsNull() {
		System.out.println("Début du test : testIsNull");

		// Given
		Animal animal1 = null;
		Animal animal2 = new Animal("Kiwi", false, 25);

		// When
		boolean result = animal2.equals(animal1);

		// Then
		assertEquals(false, result);

	}

	@Test
	public void testCarnivore() {
		System.out.println("Début du test : testCarnivore");

		// Given
		Animal animal1 = new Animal("Kiwi", true, 25);
		Animal animal2 = new Animal("Kiwi", false, 25);

		// When
		boolean result = animal2.equals(animal1);

		// Then
		assertEquals(false, result);

	}

	@Test
	public void testPoids() {
		System.out.println("Début du test : testPoids");

		// Given
		Animal animal1 = new Animal("Kiwi", false, 125);
		Animal animal2 = new Animal("Kiwi", false, 25);

		// When
		boolean result = animal2.equals(animal1);

		// Then
		assertEquals(false, result);

	}

	@Test
	public void testEqualsEspece() {
		System.out.println("Début du test : test testEqualsEspece");

		// Given
		Animal animal1 = new Animal("Lion", false, 25);
		Animal animal2 = new Animal("Kiwi", false, 25);

		// When
		boolean result = animal2.equals(animal1);

		// Then
		assertEquals(false, result);

	}

	@Test
	public void testEspeceNotNull() {
		System.out.println("Début du test : testEspeceNotNull");

		// Given
		Animal animal1 = new Animal("", false, 25);
		Animal animal2 = new Animal("Kiwi", false, 25);

		// When
		boolean result = animal2.equals(animal1);

		// Then
		assertEquals(false, result);

	}

	@Test
	public void testClassesDifferentes() {
		System.out.println("Début du test : testClassesDifferentes");

		// Given
		Animal animal1 = new Animal("", false, 25);
		// When
		boolean result = animal1.equals("kiwi");

		// Then
		assertEquals(false, result);

	}

	@Test
	public void testEspeceEquals() {
		System.out.println("Début du test : testEspeceEquals");

		// Given
		Animal animal1 = new Animal("Kiwi", false, 25);
		Animal animal2 = new Animal("Kiwi", false, 25);

		// When
		boolean result = animal2.equals(animal1);

		// Then
		assertEquals(true, result);

	}
	@Test
	public void testEspeceAnimal1Null() {
		System.out.println("Début du test : testEspeceAnimal1Null");

		// Given
		Animal animal1 = new Animal(null, false, 25);
		Animal animal2 = new Animal("Kiwi", false, 25);

		// When
		boolean result = animal1.equals(animal2);

		// Then
		assertEquals(false, result);

	}
	@Test
	public void testEspeceToSring() {
		System.out.println("Début du test : test espèce toString");

		// Given
		Animal animal1 = new Animal("Lion", false, 25.0f);

		// When
		String result = animal1.toString();

		// Then
		assertEquals("espece=[Lion], isCarnivore=[false], poids=[25.0]", result);

	}
}
