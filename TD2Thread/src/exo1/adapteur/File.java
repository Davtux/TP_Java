package exo1.adapteur;

public interface File<E> {
	/**
	 * 
	 * @return
	 */
	E tete();
	
	/**
	 * 
	 * @param e
	 */
	void insererQueue(E e);
	
	/**
	 * 
	 * @return
	 */
	E retirerTete();
	
	/**
	 * 
	 * @return
	 */
	int longueur();
	
	/**
	 * 
	 * @return
	 */
	boolean estVide();
}
