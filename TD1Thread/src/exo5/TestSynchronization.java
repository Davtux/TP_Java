package exo5;

public class TestSynchronization {
	private static class ConcurrentThread extends Thread{
		final Compteur c;
		
		public ConcurrentThread(String nom, Compteur c) {
			super(nom);
			this.c = c;
		}
		
		@Override
		public void run() {
			
			for(int i=0;i<1_000_000;i++){
				c.next();
			}
			System.out.println("Thread fini :"+Thread.currentThread());
			
		}
	}
	
	public static void main(String[] args) {
		Thread tabThread[] = new Thread[10];
		final Compteur compteur = new Compteur();
		
		for(int i=0 ; i<10 ; i++){
			tabThread[i] = new ConcurrentThread("Thread"+i, compteur);
			tabThread[i].start();
		}
		
		for(int i=0 ; i<10 ; i++){
			try {
				//On joint les threads afin d'attendre que tous les threads s'arrêtent avant
				// d'afficher la valeur finale du compteur
				tabThread[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Valeur du compteur : "+compteur.getL());
		
		
	}
}
