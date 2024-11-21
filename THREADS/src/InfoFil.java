
public class InfoFil extends Thread {
	//constructor
	public InfoFil (String nomFil) {
		this.setName(nomFil);
	}
		
	public void run() {
		//Informació fil
		System.out.println("Thread info:");
		System.out.println("  -name: " +this.getName());
		System.out.println("  -ID: " +this.getId());
		System.out.println("  -Priority: " +this.getName());
		System.out.println("  -Is daemon: " +this.isDaemon());
		System.out.println("  -State: " +this.getState());
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(this.getName()+ " has been interrupted.");
		}
		System.out.println("Final state: " +this.getState());
	}
	
	public static void main (String[] args) {
		System.out.println("\nMain thread ==> Starts");
		
		InfoFil fil1 = new InfoFil("Thread one");
		InfoFil devil = new InfoFil("Belcebu");
		devil.setDaemon(true);
		
		System.out.println("Main thread ==> Executing new threads...");
		fil1.start();
		devil.start();
		
		try {
			fil1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Is Alive?");
		if (devil.isAlive()) {
			System.out.println(devil+ " is alive.");
		} else {
			System.out.println(devil+ " is dead.");
		}
	}
	
}
