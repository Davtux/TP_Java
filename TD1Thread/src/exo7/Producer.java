package exo7;

import java.util.List;

public class Producer implements Runnable {

	private List<String> strings;
	private int size;

	public Producer(List<String> strings, int size) {
		this.strings = strings;
		this.size = size;
	}

	public void produce() {
		this.strings.add("Je suis une chaine de caractère !");
		this.size = strings.size();
	}

	public List<String> getStrings() {
		return strings;
	}

	public void setStrings(List<String> strings) {
		this.strings = strings;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public void run() {

		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			produce();

		}
	}
}