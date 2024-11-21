package Example2_9_CotxeCompartit_lockCondition;

import Exemple2_7_CotxeCompartit.Cotxe;
import Exemple2_7_CotxeCompartit.MembreFamiliar;

public class Main {
	public static void main(String[] args) {
		//creem objecte compartit
		Cotxe captur = new Cotxe("Renault Captur");
		
		//creació fils amb objectes Runnable
		Thread filPare = new Thread(new MembreFamiliar("Treballar", 10000,captur), "pare");
		Thread filMare = new Thread(new MembreFamiliar("Botiga", 5000,captur), "mare");
		Thread filFilla = new Thread(new MembreFamiliar("Universitat", 6000,captur), "filla");
		
		//llancem els fils
		filPare.start();
		filMare.start();
		filFilla.start();

		//espera fils
		try {
			filPare.join();
			filMare.join();
			filFilla.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("[" +Thread.currentThread().getName()+ "] Finalització main thread");
	}
}
