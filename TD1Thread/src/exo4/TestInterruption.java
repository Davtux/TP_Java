package exo4;


public class TestInterruption {

	public static void main(String[] args) {
		Task t = new Task();
		
		Thread thread = new Thread(t);
		thread.start();

		try {
			Thread.sleep(2_000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		thread.interrupt();
		
	}

}
