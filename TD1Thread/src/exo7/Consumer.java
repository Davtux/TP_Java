package exo7;

import java.util.List;

public class Consumer implements Runnable {

	private List<String> strings;

	public void consume() {
		if (this.strings.size() == 0) {
			try {
				synchronized (this.strings) {
					this.strings.wait();
				}
				this.consume();
			} catch (InterruptedException e) {
				System.out.println("Réveil du consommateur");
			}
		} else {
			this.strings.remove(this.strings.size() - 1);
			System.out.println("Consommation d'une chaine");
			synchronized (this.strings) {
				this.strings.notify();
			}
		}
	}

	public Consumer(List<String> strings) {
		this.strings = strings;
	}

	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(500L);
				consume();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
