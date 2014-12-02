package exo1;

public class TestWhoIsThread {

	public static void main(String[] args) throws InterruptedException {

		System.out.println(Thread.currentThread());

		final WhoIsThreadE threadA = new WhoIsThreadE();
		final WhoIsThreadE threadB = new WhoIsThreadE();

		final WhoIsThreadI thread1 = new WhoIsThreadI();
		final WhoIsThreadI thread2 = new WhoIsThreadI();

		threadA.start();
		threadB.start();
	
		new Thread(thread1).start();
		new Thread(thread2).start();

	}
}
