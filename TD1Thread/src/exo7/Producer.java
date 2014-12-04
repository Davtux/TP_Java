package exo7;

import java.util.List;

public class Producer implements Runnable {

	private List<String> strings;
	private final int SIZE = 10;

	public Producer(List<String> strings) {
		this.strings = strings;
	}

	public void produce() {
		if (this.strings.size() == SIZE) {
			try {
				synchronized (this.strings) {
					this.strings.wait();
				}

			} catch (InterruptedException e) {
				System.out.println("Réveil du producteur");
			}
		}
		this.strings.add("Je suis une chaine de caractère !");
		System.out.println("Production d'une chaine");
		synchronized (this.strings) {
			this.strings.notify();
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				// On passe à 250 ms pour que le producteur produise deux fois
				// plus que ce que le consommateur peut consommer
				// Au départ la production est deux fois plus rapide que la
				// consommation, une fois la liste pleine la produciton et la
				// consommation se font à la même vitesse.

				Thread.sleep(250L);
				produce();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}