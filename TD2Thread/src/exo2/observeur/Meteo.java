package exo2.observeur;

public class Meteo implements Observateur {

	@Override
	/**
	 * 
	 */
	public void modifier(Donnee donnee) {
		System.out.println(donnee);
	}

}
