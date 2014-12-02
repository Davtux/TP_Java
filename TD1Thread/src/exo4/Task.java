package exo4;

public class Task implements Runnable {

	public Task() {

	}

	@Override
	public void run() {

		try {
			while (true) {
				//Aucun point ne s'affiche si le temps de sommeil dépasse les 2 000 ms.
				Thread.sleep(10_000L);
				System.out.print(".");
			}
		} catch (InterruptedException e) {
			System.out.println("Arrêt du thread : "+Thread.currentThread());
		}
	}
}
