package exo6;

import exo5.Compteur;

public class TestNotification {
	public enum Parite {
		Pair, Impair
	};

	private static class ConcurrentThread extends Thread {
		private final Compteur c;

		private final Parite parite;

		public ConcurrentThread(String nom, Compteur c, Parite parite) {
			super(nom);
			this.parite = parite;
			this.c = c;
		}

		@Override
		public void run() {

			while (c.getL() < 1_000_000) {
				if (parite.equals(Parite.Pair) && c.getL() % 2 == 0) {
					c.next();

					System.out.println(c.getL());

					
				}
				else {
					c.next();
					System.out.println(c.getL());

				}

				try {
					synchronized (c) {
						c.notifyAll();
						c.wait();
					}
				} catch (InterruptedException e) {
					System.out.println("Réveil de " + Thread.currentThread());
				}
			}
			System.out.println("Thread fini :" + Thread.currentThread());

		}
	}

	public static void main(String[] args) {
		Compteur compteur = new Compteur();

		Thread 	threadA = new ConcurrentThread("ThreadA", compteur, Parite.Pair), 
				threadB = new ConcurrentThread("ThreadB", compteur, Parite.Impair);
		
		threadA.start();
		threadB.start();
		
		try {
			threadA.join();
			threadB.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

	}
}
