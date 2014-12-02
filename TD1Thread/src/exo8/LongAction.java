package exo8;

public class LongAction {
	public void traitementLong(){
		for (int i=0 ; i<100; i++){
			System.out.print(".");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
