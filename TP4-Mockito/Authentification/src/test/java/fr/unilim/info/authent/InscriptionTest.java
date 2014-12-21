package fr.unilim.info.authent;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import fr.unilim.info.authent.exception.CompteDejaInscritException;
import fr.unilim.info.authent.exception.CompteInexistantException;

public class InscriptionTest {

	@Mock
	private IAnnuaire annuaire;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInscririIdEtMDPNull() throws CompteDejaInscritException {
		System.out.println("Début du test : testInscrireIdEtMDPNull");
		// Given
		this.annuaire = Mockito.mock(IAnnuaire.class);
		ServiceAuthentification sa = new ServiceAuthentification(annuaire);

		// When
		sa.inscrire(null, null);

		// Then
		fail();

	}

	@Test(expected = IllegalArgumentException.class)
	public void testInscririIdNull() throws CompteDejaInscritException {
		System.out.println("Début du test : testInscrireIdNull()");
		// Given
		this.annuaire = Mockito.mock(IAnnuaire.class);
		ServiceAuthentification sa = new ServiceAuthentification(annuaire);

		// When
		sa.inscrire(null, "MonBeauMotDePasse");

		// Then
		fail();

	}

	@Test(expected = IllegalArgumentException.class)
	public void testInscririMDPNull() throws CompteDejaInscritException {
		System.out.println("Début du test : testInscrireMDPNull()");
		// Given
		this.annuaire = Mockito.mock(IAnnuaire.class);
		ServiceAuthentification sa = new ServiceAuthentification(annuaire);

		// When
		sa.inscrire("mon bel ID", null);

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
		ServiceAuthentification sa = new ServiceAuthentification(annuaire);

		// When
		sa.inscrire("Jacques", "Paul");

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
		ServiceAuthentification sa = new ServiceAuthentification(annuaire);

		// When
		boolean test = sa.inscrire("Jacques", "Paul");

		// Then
		assertTrue(test);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testDesinscrireIdNull() throws CompteInexistantException {
		System.out.println("Début du test : testDesinscrireIdNull()");
		// Given
		this.annuaire = Mockito.mock(IAnnuaire.class);

		ServiceAuthentification sa = new ServiceAuthentification(annuaire);

		// When
		sa.desinscrire(null);

		// Then
		fail();
	}

	@Test(expected = CompteInexistantException.class)
	public void testDesinscrireCompteNonExistant()
			throws CompteInexistantException {
		System.out
				.println("Début du test : testDesinscrireCompteNonExistant()");
		// Given
		this.annuaire = Mockito.mock(IAnnuaire.class);

		ServiceAuthentification sa = new ServiceAuthentification(annuaire);

		// When
		Mockito.when(annuaire.recupererCompteParIdentifiant("Jacques"))
				.thenReturn(null);
		sa.desinscrire("Jacques");

		// Then
		fail();
	}

	@Test
	public void testDesinscrireCompteExistantSuppressionOK()
			throws CompteInexistantException {
		System.out
				.println("Début du test : testDesinscrireCompteExistantSuppressionOK()");
		// Given
		this.annuaire = Mockito.mock(IAnnuaire.class);

		ServiceAuthentification sa = new ServiceAuthentification(annuaire);

		// When
		Mockito.when(annuaire.recupererCompteParIdentifiant("Jacques"))
				.thenReturn(new Compte("Jacques"));
		Mockito.when(annuaire.supprimerCompte("Jacques")).thenReturn(true);
		boolean res = sa.desinscrire("Jacques");

		// Then
		assertTrue(res);
	}

	@Test
	public void testDesinscrireCompteExistantProblemeSuppression()
			throws CompteInexistantException {
		System.out
				.println("Début du test : testDesinscrireCompteExistantProblemeSuppression()");
		// Given
		this.annuaire = Mockito.mock(IAnnuaire.class);

		ServiceAuthentification sa = new ServiceAuthentification(annuaire);

		// When
		Mockito.when(annuaire.recupererCompteParIdentifiant("Jacques"))
				.thenReturn(new Compte("Jacques"));
		Mockito.when(annuaire.supprimerCompte("Jacques")).thenReturn(false);
		boolean res = sa.desinscrire("Jacques");

		// Then
		assertFalse(res);
	}

}
