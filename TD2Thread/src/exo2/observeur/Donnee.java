package exo2.observeur;

public class Donnee {
	private final double temperature, precipitation, pression;
	
	/**
	 * 
	 * @param temperature
	 * @param precipitation
	 * @param pression
	 */
	public Donnee(double temperature, double precipitation, double pression) {
		this.temperature = temperature;
		this.precipitation = precipitation;
		this.pression = pression;
	}

	/**
	 * 
	 * @return
	 */
	public double getTemperature() {
		return temperature;
	}

	/**
	 * 
	 * @return
	 */
	public double getPrecipitation() {
		return precipitation;
	}

	/**
	 * 
	 * @return
	 */
	public double getPression() {
		return pression;
	}

	@Override
	/**
	 * 
	 */
	public String toString() {
		return "Donnee [temperature=" + temperature + ", precipitation="
				+ precipitation + ", pression=" + pression + "]";
	}
	
	
	
}
