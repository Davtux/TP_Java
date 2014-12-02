package exo7;

import java.util.List;

public class Consumer implements Runnable {

	private List<String> strings;

	public void consume() {
		this.strings.remove(this.strings.size()-1);
	}

	private Consumer(List<String> strings) {
		this.strings = strings;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			consume();

		}

	}

}
