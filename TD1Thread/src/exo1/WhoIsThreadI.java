package exo1;

public class WhoIsThreadI implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(500);
				System.out.println(this);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public String toString(){
		return Thread.currentThread().getName();
	}

}
