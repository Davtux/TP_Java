package exo2;


public class Demon extends Thread {
	public Demon(String name) {
		super(name);
		this.setDaemon(true);
	}

	@Override
	public void run() {
		try {
			// On fait les 20 affichages dans le cas du thread normal
			// et 2 ou 3 affichages une fois transform� en d�mon
			for (int i = 0; i < 20; i++) {
				System.out.println(Thread.currentThread());
				Thread.sleep(500L);
			}
		} catch (InterruptedException e) {
			System.out.println("Arr�t forc� du thread : "+ Thread.currentThread());
		} finally {
			// On passe ici dans le cas o� on n'a pas encore transform� le thread en thread d�mon
			
			// Une fois transform� en thread d�mon, celui-ci s'arr�te d�s que le thread principal se termine
			System.out.println("Pas un d�mon");
		}

		System.out.println("Fin du thread : " + Thread.currentThread());
	}
}
