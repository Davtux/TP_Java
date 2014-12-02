package exo9;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task implements Runnable {

	@Override
	public void run() {
		Date date;
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");

		try {
			for (int i = 0; i < 20; i++) {
				// On se contente de lire l'heure ici, il n'y a pas de calcul ou
				// d'affectation
				// � la ressource � laquelle acc�dent les diff�rents threads,
				// donc la classe est thread safe
				date = new Date();

				System.out.println(Thread.currentThread() + " : "
						+ df.format(date));

				Thread.sleep(1_000L);

			}
		} catch (InterruptedException e) {
			System.out.println("Arr�t forc� du thread : "+ Thread.currentThread());
		}

		System.out.println("Fin du thread : " + Thread.currentThread());
	}

}
