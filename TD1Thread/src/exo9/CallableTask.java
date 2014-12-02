package exo9;

import exo5.Compteur;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<Compteur> {
	Compteur compteur;
	
	public CallableTask() {
		this.compteur = new Compteur();
	}
	
	@Override
	public Compteur call() {
		
		try {
			for (int i = 0; i < 10; i++) {
				compteur.next();

				System.out.println(Thread.currentThread() + " : "+compteur.getL());

				Thread.sleep(1_000L);
			}
		} catch (InterruptedException e) {
			System.out.println("Arr�t forc� : "+ Thread.currentThread());
		}
		
		System.out.println("Fin : " + Thread.currentThread());
		
		// En utilisant une interface Runnable, on ne peut pas renvoyer de r�sultat � la
		// fin de l'ex�cution de la m�thode run(), 
		// alors qu'on peut ici avec l'interface Callable
		return compteur;
	}

}
