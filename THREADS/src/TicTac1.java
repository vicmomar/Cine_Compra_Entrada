
public class TicTac1 implements Runnable{

	private String nomFil;
	
	public TicTac1 (String nomFil) {
		this.nomFil = nomFil;
	}
	public TicTac1 () {
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			if (this.nomFil.equals("TIC")) {
				for (int i=0; i<5; i++) {
					System.out.println(this.nomFil);
					Thread.sleep(1000);
				}
			} else {
				for (int i=0; i<5; i++) {
					if ( i == 0)
						Thread.sleep(500);
					System.out.println(this.nomFil);
					Thread.sleep(1000);
				}
			}
			
			
		} catch (InterruptedException e) {
			e.getMessage();
		}
	}
	
	public static void main (String[] args) {
		System.out.println("\nMain thread ==> Starts");
		
		Thread filTic = new Thread(new TicTac1("TIC"));
		Thread filTac = new Thread(new TicTac1("TAC"));
		
		System.out.println("\nMain thread ==> Executing new thread...");
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
