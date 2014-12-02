package exo9;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import exo5.Compteur;


public class TestExecutorService {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2); 
			
		executorService.submit(new Task());
		executorService.submit(new Task());
		
		// Si on soumet trois instances de la classe Task au lieu de deux, les deux premi�res instances vont s'ex�cuter
		// tandis que la troisi�me va attendre que l'une des deux soit finie pour s'ex�cuter
		executorService.submit(new Task());
		
		try {
			Thread.sleep(2_000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// On interrompt toutes les t�ches au bout de 2 secondes
		executorService.shutdownNow();

		
		Compteur compteur = new CallableTask().call();
		// On r�cup�re le r�sultat des incr�mentations successives
		System.out.println(Thread.currentThread()+" : "+compteur.getL());
			
	}

}
