package exo2.observeur;

public class Meteo implements Observateur {

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo2.observeur.Observateur#modifier(exo2.observeur.Donnee)
	 */
	@Override
	public void modifier(Donnee donnee) {
		System.out.println(donnee);
	}

}
