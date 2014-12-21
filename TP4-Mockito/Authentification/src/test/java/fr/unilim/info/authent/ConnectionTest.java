package fr.unilim.info.authent;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import fr.unilim.info.authent.exception.CompteInactifException;
import fr.unilim.info.authent.exception.CompteInexistantException;
import fr.unilim.info.authent.exception.MotDePasseIncorrectException;

public class ConnectionTest {
	@Mock
	IAnnuaire annuaire;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test(expected = CompteInexistantException.class)
	public void testConnecterIdNull() throws CompteInexistantException,
			CompteInactifException, MotDePasseIncorrectException {
		System.out.println("Début du test : testConnecterIdNull");

		// Given
		this.annuaire = Mockito.mock(IAnnuaire.class);
		ServiceAuthentification sa = new ServiceAuthentification(annuaire);

		// When
		sa.connecter(null, "1234");

		// Then
		fail();
	}

	@Test(expected = CompteInexistantException.class)
	public void testConnecterCompteInexistant()
			throws CompteInexistantException, CompteInactifException,
			MotDePasseIncorrectException {
		System.out.println("Début du test : testConnecterCompteInexistant");
		
		// Given
		this.annuaire = Mockito.mock(IAnnuaire.class);
		ServiceAuthentification sa = new ServiceAuthentification(annuaire);
		sa.setSessionsEnCours(CompteFixture.creerListeComptes());

		// When
		sa.connecter("Noel", "Flantier");

		// Then
		fail();
	}

	@Test(expected = CompteInactifException.class)
	public void testConnecterCompteInactif() throws CompteInexistantException,
			CompteInactifException, MotDePasseIncorrectException {
		System.out.println("Début du test : testConnecterCompteInactif");
		
		// Given
		this.annuaire = Mockito.mock(IAnnuaire.class);

		ServiceAuthentification sa = new ServiceAuthentification(annuaire);
		sa.setSessionsEnCours(CompteFixture.creerListeComptes());

		Compte compte = new Compte("AZER1234");
		compte.setActif(false);

		// When
		Mockito.when(annuaire.recupererCompteParIdentifiant("AZER1234"))
				.thenReturn(compte);
		sa.connecter("AZER1234", "1234");

		// Then
		fail();
	}

	@Test(expected = MotDePasseIncorrectException.class)
	public void testConnecterMotDePasseIncorrect()
			throws CompteInexistantException, CompteInactifException,
			MotDePasseIncorrectException {
		System.out.println("Début du test : testConnecterMotDePasseIncorrect");
		
		// Given
		this.annuaire = Mockito.mock(IAnnuaire.class);

		ServiceAuthentification sa = new ServiceAuthentification(annuaire);
		sa.setSessionsEnCours(CompteFixture.creerListeComptes());

		Compte compte = new Compte("AZER1234");

		// When
		Mockito.when(annuaire.recupererCompteParIdentifiant("AZER1234"))
				.thenReturn(compte);
		Mockito.when(annuaire.verifierMotDePasse("AZER1234", "1234"))
				.thenReturn(false);
		sa.connecter("AZER1234", "1234");

		// Then
		fail();
	}

	@Test
	public void testConnecterReussiteDejaConnecte()
			throws CompteInexistantException, CompteInactifException,
			MotDePasseIncorrectException {
		System.out.println("Début du test : testConnecterReussiteDejaConnecte");
		
		// Given
		this.annuaire = Mockito.mock(IAnnuaire.class);

		ServiceAuthentification sa = new ServiceAuthentification(annuaire);
		sa.setSessionsEnCours(CompteFixture.creerListeComptes());

		Compte compte = new Compte("AZER1234");

		// When
		Mockito.when(annuaire.recupererCompteParIdentifiant("AZER1234"))
				.thenReturn(compte);
		Mockito.when(annuaire.verifierMotDePasse("AZER1234", "1234"))
				.thenReturn(true);
		sa.connecter("AZER1234", "1234");

		// Then

	}

	@Test
	public void testConnecterReussitePasEncoreConnecte()
			throws CompteInexistantException, CompteInactifException,
			MotDePasseIncorrectException {
		System.out.println("Début du test : testConnecterReussitePasEncoreConnecte");
		
		// Given
		this.annuaire = Mockito.mock(IAnnuaire.class);

		ServiceAuthentification sa = new ServiceAuthentification(annuaire);
		sa.setSessionsEnCours(CompteFixture.creerListeComptes());

		Compte compte = new Compte("AHAHAHA");

		// When
		Mockito.when(annuaire.recupererCompteParIdentifiant("AHAHAHA"))
				.thenReturn(compte);
		Mockito.when(annuaire.verifierMotDePasse("AHAHAHA", "1234"))
				.thenReturn(true);
		sa.connecter("AHAHAHA", "1234");

		// Then

	}

	@Test
	public void testDeconnecterIdNull() {
		System.out.println("Début du test : testDeconnecterIdNull");
		
		// Given
		this.annuaire = Mockito.mock(IAnnuaire.class);
		ServiceAuthentification sa = new ServiceAuthentification(annuaire);

		// When
		boolean res = sa.deconnecter(null);

		// Then
		assertFalse(res);
	}

	@Test
	public void testDeconnecterEstConnecte() {
		System.out.println("Début du test : testDeconnecterEstConnecte");
		
		// Given
		this.annuaire = Mockito.mock(IAnnuaire.class);
		ServiceAuthentification sa = new ServiceAuthentification(annuaire);
		sa.setSessionsEnCours(CompteFixture.creerListeComptes());

		// When
		boolean res = sa.deconnecter("AZER1234");

		// Then
		assertTrue(res);
	}

	@Test
	public void testDeconnecterNonConnecte() {
		System.out.println("Début du test : testDeconnecterNonConnecte");
		
		// Given
		this.annuaire = Mockito.mock(IAnnuaire.class);
		ServiceAuthentification sa = new ServiceAuthentification(annuaire);
		sa.setSessionsEnCours(CompteFixture.creerListeComptes());

		// When
		boolean res = sa.deconnecter("AHAHAHAH");

		// Then
		assertFalse(res);
	}

	@Test
	public void testEstConnecteIdNull() {
		System.out.println("Début du test : testEstConnecteIdNull");
		
		// Given
		this.annuaire = Mockito.mock(IAnnuaire.class);
		ServiceAuthentification sa = new ServiceAuthentification(annuaire);
		sa.setSessionsEnCours(CompteFixture.creerListeComptes());

		// When
		boolean res = sa.estConnecte(null);

		// Then
		assertFalse(res);
	}

	@Test
	public void testEstConnecteVrai() {
		System.out.println("Début du test : testEstConnecteVrai");
		
		// Given
		this.annuaire = Mockito.mock(IAnnuaire.class);
		ServiceAuthentification sa = new ServiceAuthentification(annuaire);
		sa.setSessionsEnCours(CompteFixture.creerListeComptes());

		// When
		boolean res = sa.estConnecte("AZER1234");

		// Then
		assertTrue(res);
	}

	@Test
	public void testEstConnecteFaux() {
		System.out.println("Début du test : testEstConnecteFaux");
		
		// Given
		this.annuaire = Mockito.mock(IAnnuaire.class);
		ServiceAuthentification sa = new ServiceAuthentification(annuaire);
		sa.setSessionsEnCours(CompteFixture.creerListeComptes());

		// When
		boolean res = sa.estConnecte("AHAHAHA");

		// Then
		assertFalse(res);
	}

}
