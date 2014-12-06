package exo2.observeur;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestObservateur {
	public static void main(String[] args) {

		final Capteur capteur = new Capteur();
		final ExecutorService executorService = Executors
				.newSingleThreadExecutor();

		// On va démarrer le capteur à l'aide d'un executorService

		Observateur meteo = new Meteo();
		Observateur grapheur = new Grapheur();
		Observateur statistique = new Statistique();

		capteur.ajouterObservateur(meteo);
		capteur.ajouterObservateur(grapheur);
		capteur.ajouterObservateur(statistique);

		executorService.submit(capteur);
		try {
			Thread.sleep(10_000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executorService.shutdownNow();

	}
}
