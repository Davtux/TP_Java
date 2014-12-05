package exo2.observeur;

import java.util.ArrayList;
import java.util.List;

public class Statistique implements Observateur {

	List<Double> donnees = new ArrayList<Double>();

	/**
	 * 
	 */
	public Statistique() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return
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
	 * 
	 * @return
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
	 * 
	 * @return
	 */
	public double getCumulTemperature() {
		double cumulTemp = donnees.get(0);
		for (int i = 1; i < donnees.size(); i++) {
			cumulTemp = cumulTemp + donnees.get(i);
		}
		return cumulTemp/donnees.size();
	}

	@Override
	/**
	 * 
	 */
	public void modifier(Donnee donnee) {
		donnees.add(donnee.getTemperature());
		System.out.println("Température minimale : "+getMinTemperature());
		System.out.println("Température maximale : "+getMaxTemperature());
		System.out.println("Cumul des températures : "+getCumulTemperature());
	}

}
