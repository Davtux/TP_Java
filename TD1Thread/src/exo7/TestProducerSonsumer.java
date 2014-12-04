package exo7;

import java.util.ArrayList;
import java.util.List;

public class TestProducerSonsumer {

	public static void main(String[] args) {
		List<String> strings = new ArrayList<String>();
		Producer producer = new Producer(strings);
		Consumer consumer = new Consumer(strings);
		// Pour augmenter la consommation sans toucher à l'intervalle il faut
		// instancier un nouveau comsommateur

		// Consumer consumer2 = new Consumer(strings);

		new Thread(producer).start();
		new Thread(consumer).start();
		// new Thread(consumer2).start();

	}

}
