package fr.unilim.info.authent;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import fr.unilim.info.authent.exception.CompteDejaInscritException;

public class InscriptionTest {

	@Mock
	private IAnnuaire annuaire;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInscririIdEtMDPNull() throws CompteDejaInscritException {
		System.out.println("Début du test : testInscririIdEtMDPNull");
		// Given
		this.annuaire = Mockito.mock(IAnnuaire.class);
		ServiceAuthentification SA = new ServiceAuthentification(annuaire);

		// When
		SA.inscrire(null, null);

		// Then
		fail();

	}

	@Test(expected = IllegalArgumentException.class)
	public void testInscririIdNull() throws CompteDejaInscritException {
		System.out.println("Début du test : testInscririIdNull()");
		// Given
		this.annuaire = Mockito.mock(IAnnuaire.class);
		ServiceAuthentification SA = new ServiceAuthentification(annuaire);

		// When
		SA.inscrire(null, "MonBeauMotDePasse");

		// Then
		fail();

	}

	@Test(expected = IllegalArgumentException.class)
	public void testInscririMDPNull() throws CompteDejaInscritException {
		System.out.println("Début du test : testInscririMDPNull()");
		// Given
		this.annuaire = Mockito.mock(IAnnuaire.class);
		ServiceAuthentification SA = new ServiceAuthentification(annuaire);

		// When
		SA.inscrire("mon bel ID", null);

		// Then
		fail();

	}

	@Test(expected = CompteDejaInscritException.class)
	public void testInscrireCompteExistant() throws CompteDejaInscritException {
		System.out.println("Début du test : testInscrireCompteExistant()");
		// Given
		this.annuaire = Mockito.mock(IAnnuaire.class);

		Mockito.when(annuaire.recupererCompteParIdentifiant("Jacques"))
				.thenReturn(new Compte("Jacques"));
		ServiceAuthentification SA = new ServiceAuthentification(annuaire);

		// When
		SA.inscrire("Jacques", "Paul");

		// Then
		fail();

	}

	@Test
	public void testInscrireCompteOK() throws CompteDejaInscritException {
		System.out.println("Début du test : testInscrireCompteOK()");
		// Given
		this.annuaire = Mockito.mock(IAnnuaire.class);

		Mockito.when(annuaire.recupererCompteParIdentifiant("Jacques"))
				.thenReturn(null);
		Mockito.when(annuaire.creerCompte("Jacques", "Paul")).thenReturn(true);
		ServiceAuthentification SA = new ServiceAuthentification(annuaire);

		// When
		boolean test = SA.inscrire("Jacques", "Paul");

		// Then
		assertTrue(test);

	}
	
	
}
