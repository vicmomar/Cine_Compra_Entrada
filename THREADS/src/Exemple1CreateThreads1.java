
public class Exemple1CreateThreads1 extends Thread {

	//constructor
	public Exemple1CreateThreads1 (String nomFil) {
		this.setName(nomFil);
	}
	
	//mètode Run
	public void run() {
		System.out.println("\tFil [" +this.getName()+ "] ==> Hi, I'm the thread " +this.getName());
		System.out.println("\tFil [" +this.getName()+ "] ==> Thread " +this.getName()+ " just finished.");
	}
	
	//main
	public static void main(String[] args) {
		System.out.println("\nMain thread ==> Starts");
		
		//nou fil 1
		Exemple1CreateThreads1 objFil1 = new Exemple1CreateThreads1("Thread one");
		//nou fil 2
		Exemple1CreateThreads1 objFil2 = new Exemple1CreateThreads1("Thread two");
		
		System.out.println("Main thread ==> Executing new threads...");
		objFil1.start();
		objFil2.start();
		
		try {
			objFil1.join();
			objFil2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main thread ==> Just finished.\n");
	}
	
}
