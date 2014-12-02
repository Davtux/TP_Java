package exo3;

public class TestArret {

	public static void main(String[] args) {
		Task t = new Task();
		
		new Thread(t).start();
		
		try {
			Thread.sleep(2_000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t.setStopped(true);
	}

}
