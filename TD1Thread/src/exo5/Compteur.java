package exo5;

public class Compteur {
	private long l;
	
	public Compteur() {
		l=0;
	}

	// Sans le mot-clé synchronized, le programme n'est pas thread-safe car il y a un risque
	// d'accès concurrent à la ressource l
	public synchronized long getL() {
		return l;
	}

	public synchronized void next() {
		this.l ++;
	}
	
	
}
