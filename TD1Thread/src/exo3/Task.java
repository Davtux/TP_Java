package exo3;

public class Task implements Runnable {
	
	private boolean stopped;

	public Task() {
		stopped=false;
	}
	
	@Override
	public void run() {
		while(!this.isStopped()){
			try {
				//Un seul point est affiché si le thread dort 10_000 ms
				Thread.sleep(100L);
				System.out.print(".");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// 2 threads différents vont tenter d'accéder à la variable stopped en même temps, il faut donc ajouter le
	// mot-clé synchronized aux méthodes setStopped et isStopped
	public synchronized void setStopped(boolean stopped) {
		this.stopped = stopped;
	}

	private synchronized boolean isStopped() {
		return this.stopped;
	}

}
