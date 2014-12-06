package exo2.observeur;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Capteur implements Sujet, Runnable {
	private List<Observateur> liste;
	private Donnee donnee;

	/**
	 * 
	 */
	public Capteur() {
		liste = new ArrayList<Observateur>();
	}

	@Override
	/**
	 * 
	 */
	public void ajouterObservateur(Observateur observateur) {
		this.liste.add(observateur);

	}

	@Override
	/**
	 * 
	 */
	public void retirerObservateur(Observateur observateur) {
		this.liste.remove(observateur);

	}

	@Override
	/**
	 * 
	 */
	public void notifierObservateurs() {
		for (Observateur obs : this.liste) {
			obs.modifier(this.donnee);
		}

	}

	@Override
	/**
	 * 
	 */
	public void run() {
		try {
			while (!Thread.currentThread().isInterrupted()) {

				donnee = new Donnee(ThreadLocalRandom.current().nextDouble(-30,
						40), ThreadLocalRandom.current().nextDouble(0, 100),
						ThreadLocalRandom.current().nextDouble(800, 1200));
				this.notifierObservateurs();
				Thread.sleep(500L);
			}
		} catch (InterruptedException ie) {
			System.out.println("Arrêt du run");

		}
	}
}
