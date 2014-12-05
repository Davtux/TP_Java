package exo2.observeur;

public class Statistique implements Observateur{
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
	public double getMinTemperature(){
		return 0;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getMaxTemperature(){
		return 0;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getCumulTemperature(){
		return 0;
	}

	@Override
	/**
	 * 
	 */
	public void modifier(Donnee donnee) {
		// TODO Auto-generated method stub
		
	}

}
