package exo2.observeur;

import java.util.ArrayList;
import java.util.List;

public class Capteur implements Sujet, Runnable{
	List<Observateur> liste;
	Donnee donnee;
	
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
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * 
	 */
	public void retirerObservateur(Observateur observateur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * 
	 */
	public void notifierObservateurs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * 
	 */
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
