
public class TicTac2 {

private String nomFil;
	
	public TicTac2 (String nomFil) {
		this.nomFil = nomFil;
	}
	public TicTac2 () {
	}
	
	
	class Tic implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				for (int i=0; i<5; i++) {
					System.out.println("TIC");
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.getMessage();
			}
			
		}
		
	}
	
	class Tac implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				for (int i=0; i<5; i++) {
					if ( i == 0) {
						Thread.sleep(500);
					}
					System.out.println("TAC");
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.getMessage();
			}	
		}
	}
	
	public static void main (String[] args) {
		System.out.println("\nMain thread ==> Starts");
		
		TicTac2 ticTac = new TicTac2();
		
		Thread filTic = new Thread(ticTac.new Tic());
		Thread filTac = new Thread(ticTac.new Tac());
		
		System.out.println("\nMain thread ==> Executing new threads...");
		filTic.start();
		filTac.start();
		
		try {
			filTic.join();
			filTac.join();
		} catch (InterruptedException e) {
			e.getMessage();
		}
		System.out.println("Main thread ==> just finished.");
	}
}
