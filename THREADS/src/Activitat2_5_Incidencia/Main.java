package Activitat2_5_Incidencia;

public class Main {
	public static void main (String[] args) {
		
		ServeiTecnic serveiTecnic = new ServeiTecnic();
		System.out.println("\nMain thread ==> Starts with " +serveiTecnic.obtenirIncidenciesResoltes()+ " incidències resoltes");
		
		Thread tecnic1 = new Thread(new Tecnic(serveiTecnic,"Tècnic 1"));
		Thread tecnic2 = new Thread(new Tecnic(serveiTecnic,"Tècnic 2"));
		
		System.out.println("\nMain thread ==> Executing new thread...");
		tecnic1.start();
		tecnic2.start();
		
		try {
			tecnic1.join();
			tecnic2.join();
		} catch (InterruptedException e) {
			e.getMessage();
		}
		System.out.println("Main thread ==> just finished with " +serveiTecnic.obtenirIncidenciesResoltes());
	}

}
