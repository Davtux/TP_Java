package exo2;

public class TestDemon {
	public static void main(String[] args) {
		new Demon("ThreadDemon").start();
		
		try {
			Thread.sleep(1_000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Arr�t "+Thread.currentThread());
	}
}
