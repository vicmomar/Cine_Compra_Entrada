package Exemple2_11_CotxeCompartit_SemaforComptador;

public class Main {
	public static void main(String[] args) {
		//creem objecte semàfor compartit
		SemaforComptador semafor = new SemaforComptador(2);
		//creem objecte compartit
		Cotxe captur = new Cotxe("Renault Captur", semafor);
		Cotxe ibiza = new Cotxe("Seat Ibiza", semafor);
		
		//creació fils amb objectes Runnable
		Thread fils[] = new Thread[4];
		fils[0] = new Thread(new MembreFamiliar("Treballar", 10000, captur, ibiza), "pare");
		fils[1] = new Thread(new MembreFamiliar("Botiga", 5000,captur, ibiza), "mare");
		fils[2] = new Thread(new MembreFamiliar("Universitat", 6000,captur, ibiza), "filla");
		fils[3] = new Thread(new MembreFamiliar("Ambulatori", 6000,captur, ibiza), "àvia");

		
		//llancem els fils
		for (Thread fil : fils) {
			fil.start();
		}

		//espera fils
		try {
			for (Thread fil : fils) {
				fil.join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("[" +Thread.currentThread().getName()+ "] Finalització main thread");
	}
}
