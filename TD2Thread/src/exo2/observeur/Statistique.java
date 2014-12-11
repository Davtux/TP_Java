package exo2.observeur;

import java.util.ArrayList;
import java.util.List;

public class Statistique implements Observateur {

	List<Double> donnees = new ArrayList<Double>();

	/**
	 * Procédure retournant la température minimale.
	 * 
	 * @return float : la température minimale.
	 */
	public double getMinTemperature() {
		double tempMin = donnees.get(0);
		for (int i = 1; i < donnees.size(); i++) {
			if (donnees.get(i) < tempMin) {
				tempMin = donnees.get(i);
			}
		}
		return tempMin;
	}

	/**
	 * Procédure retournant la température maximale.
	 * 
	 * @return float : la température maximale.
	 */
	public double getMaxTemperature() {
		double tempMax = donnees.get(0);
		for (int i = 1; i < donnees.size(); i++) {
			if (donnees.get(i) > tempMax) {
				tempMax = donnees.get(i);
			}
		}
		return tempMax;
	}

	/**
	 * Procédure calculant la moyenne des températures relevées.
	 * 
	 * @return la moyenne des températures relevées.
	 */
	public double getCumulTemperature() {
		double cumulTemp = donnees.get(0);
		for (int i = 1; i < donnees.size(); i++) {
			cumulTemp = cumulTemp + donnees.get(i);
		}
		return cumulTemp / donnees.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo2.observeur.Observateur#modifier(exo2.observeur.Donnee)
	 */
	@Override
	public void modifier(Donnee donnee) {
		donnees.add(donnee.getTemperature());
		System.out.println("Température minimale : " + getMinTemperature());
		System.out.println("Température maximale : " + getMaxTemperature());
		System.out.println("Cumul des températures : " + getCumulTemperature());
	}

}
